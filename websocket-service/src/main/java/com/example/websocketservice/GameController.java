package com.example.websocketservice;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

//    session.send("/game/start", message); строка на клиенте

//    @MessageMapping("/start") // когда клиент отправит запрос, его будет обрабоатывать запрос по первой анотации
      @MessageMapping("/start/{id}") // + id клиента (если между клиентами
    @SendTo("/play/{id}")            // кому нужно отправить запрос
    public Message sendMessage(Message message, @DestinationVariable String id){
        return new Message(message.getAuthor(), message.getMessageText());
    }

}
