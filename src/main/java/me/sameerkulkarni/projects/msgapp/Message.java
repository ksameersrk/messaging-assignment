package me.sameerkulkarni.projects.msgapp;

import java.util.Date;
import java.util.UUID;

public class Message {

    UUID id;
    String fromUser;
    String toUser;
    String body;
    Date date;
    boolean read;
    String messageType;

    public Message(String body) {
        this.body = body;
        this.id = UUID.randomUUID();
        this.date = new Date();
        this.fromUser = Util.getFromUserName();
        this.read = false;
        this.toUser = Util.getToUserName();
        this.messageType = "RECEIVED";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setMessageTypeSent() {
        this.messageType = "SENT";
    }
}
