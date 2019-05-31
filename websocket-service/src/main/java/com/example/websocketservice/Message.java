package com.example.websocketservice;

public class Message {

    private String author;
    private String messageText;

    public Message() {
    }

    public Message(String author, String messageText) {
        this.author = author;
        this.messageText = messageText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
