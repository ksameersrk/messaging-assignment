package me.sameerkulkarni.projects.msgapp;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MessageService {

    @Autowired
    RestTemplate restTemplate;

    List<Message> messageList = new CopyOnWriteArrayList<>();
    Gson gson = new Gson();

    public String sendMessage(String messageBody) {
        Message message = new Message(messageBody);
        message.setMessageTypeSent();
        messageList.add(message);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(gson.toJson(message), headers);
        String response = restTemplate.postForObject(Util.getBaseEndpoint() + "/receive", entity, String.class);
        messageList.add(0, message);
        return "Message ID : " + message.getId().toString();
    }

    public String receiveMessage(Message message) {
        messageList.add(0, message);
        return "Message Received";
    }

    public String getAllMessages() {
        for (Message message : messageList) {
            message.setRead(true);
        }
        return gson.toJson(messageList);
    }

    public String getUnreadMessages() {
        List<Message> unread = new ArrayList<>();
        for (Message message : messageList) {
            if (!message.isRead()) {
                message.setRead(true);
                unread.add(message);
            }
        }
        return gson.toJson(unread);
    }

    public String getReadMessages() {
        List<Message> read = new ArrayList<>();
        for (Message message : messageList) {
            if (message.isRead()) {
                read.add(message);
            }
        }
        return gson.toJson(read);
    }

    public String getSingleMessage(String id) {
        Message result = null;
        for (Message message : messageList) {
            if (message.getId().toString().equalsIgnoreCase(id)) {
                result = message;
                result.setRead(true);
                break;
            }
        }
        return result != null ? gson.toJson(result) : "NotFound";
    }

    public String deleteSingleMessage(String id) {
        Message result = null;
        for (Message message : messageList) {
            if (message.getId().toString().equalsIgnoreCase(id)) {
                result = message;
                break;
            }
        }
        if (result != null) {
            messageList.remove(result);
        }
        return "NotFound";
    }

    public String deleteAllMessage() {
        int listSize = messageList.size();
        messageList.clear();
        return "Total Deleted Messages : " + listSize;
    }

    public String getReceivedMessages() {
        List<Message> read = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getMessageType().equals("RECEIVED")) {
                read.add(message);
            }
        }
        return gson.toJson(read);
    }

    public String getSentMessages() {
        List<Message> read = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getMessageType().equals("SENT")) {
                read.add(message);
            }
        }
        return gson.toJson(read);
    }
}
