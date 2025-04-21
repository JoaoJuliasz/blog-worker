package com.example.blogworker.consumer;

import com.example.blogworker.model.NotificationMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionConsumer {
//    private final

    @RabbitListener(queues = "subscription-request-queue")
    public void receiver(@Payload String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        NotificationMessage notificationMessage = mapper.readValue(message, NotificationMessage.class);
//        for(Long id : notificationMessage.getUsersIds()) {
//            System.out.println(id);
//        }

    }

}
