package com.example.websocketclient;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class SessionHandler extends StompSessionHandlerAdapter {

    String id ="dsd23"; // идентификатор пользователя

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("Новая сессия: " + session.getSessionId() );
        session.subscribe("/play/" + 111, this); //  определяем на что подписываемся. this ссылается на текущий
        // обработчик - метод handleFrame. Если хотим другой то нужно указать
        // на этом моменте клиент ничего не отправляет.
        // клиент подписывается на /play


        Message message = new Message("author1", "hello");
//        session.send("/game/start", message);
        session.send("/game/start/" + 222, message);  // id - если не только с сервером обмен сообщений, тогда откуда и кому
        System.out.println("отправка");
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        // отработает когда придет какое то сообщение
        Message message = (Message) payload;
        System.out.println("Получено сообщение: " + message.getMessageText() + " от " + message.getAuthor());
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        // какими данными обмениваемся
        return Message.class;
    }


    // если произойдет какая то ошибка
//    @Override
//    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
//        super.handleException(session, command, headers, payload, exception);
//    }
//
//    @Override
//    public void handleTransportError(StompSession session, Throwable exception) {
//        super.handleTransportError(session, exception);
//    }
}
