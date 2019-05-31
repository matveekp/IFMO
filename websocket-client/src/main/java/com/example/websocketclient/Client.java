package com.example.websocketclient;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        String url = "ws://localhost:8080/gameName";

        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        // оборачиваем websocketclient в stompClient чтобы передавть JSON

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        // этот класс будет конвертировать сообщение из JSON в объект

        //указываем кто будет обрабатывать соединение между клиентом и сервером
        StompSessionHandler sessionHandler = new SessionHandler(); // обработчик соединения
        stompClient.connect(url, sessionHandler);

        Scanner in = new Scanner(System.in);
        String exit = null;
        while (!"EXIT".equals(exit)) {

            System.out.println("EXIT для выхода");

            exit = in.nextLine();

        }


    }
}
