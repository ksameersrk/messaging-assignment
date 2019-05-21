package me.sameerkulkarni.projects.msgapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String send(UserMessage userMessage) {
        return messageService.sendMessage(userMessage.getMessage());
    }

    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public String receive(Message message) {
        return messageService.receiveMessage(message);
    }

    @RequestMapping(value = "/messages/get/unread", method = RequestMethod.GET)
    public String messageGetUnread() {
        return messageService.getUnreadMessages();
    }

    @RequestMapping(value = "/messages/get/read", method = RequestMethod.GET)
    public String messageGetRead() {
        return messageService.getReadMessages();
    }

    @RequestMapping(value = "/messages/get/all", method = RequestMethod.GET)
    public String messageGetAll() {
        return messageService.getAllMessages();
    }

    @RequestMapping(value = "/messages/delete/all", method = RequestMethod.GET)
    public String messageDeleteAll() {
        return messageService.deleteAllMessage();
    }

    @RequestMapping(value = "/messages/get/sent", method = RequestMethod.GET)
    public String messageSent() {
        return messageService.getSentMessages();
    }

    @RequestMapping(value = "/messages/get/received", method = RequestMethod.GET)
    public String messageReceived() {
        return messageService.getReceivedMessages();
    }
}
