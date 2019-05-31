package com.example.websocketservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    //


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // регистрация получателей
        registry.enableSimpleBroker("/play");
        //когда клиент будет посылать запрос, его нужно зарегистрировать, чтбы потом можно было оработать
        registry.setApplicationDestinationPrefixes("/game");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // куда должны будут обращатсья клиенты, чтобы они могли пользоваться этим сервером
        registry.addEndpoint("gameName");
        // все запросы будут уходить по этому адресу - gameName



    }
}
