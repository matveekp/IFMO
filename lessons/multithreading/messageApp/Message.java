package multithreading.messageApp;

import java.io.Serializable;

public class Message implements Serializable {
    private String messageText;
    private String sender;

    public Message(String messageText, String sender) {
        this.messageText = messageText;
        this.sender = sender;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return sender+": " + messageText;
    }

    //клиент должен раз в период времени пытаться подключится к серверу.
    //при выходе exception не должно быть
    //реализовать exit
    //свои сообщения не должны быть видны...

}
