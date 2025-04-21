package com.example.blogworker.consumer;

import com.example.blogworker.model.NotificationMessage;
import com.example.blogworker.model.User;
import com.example.blogworker.service.EmailService;
import com.example.blogworker.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionConsumer {

    private final UserService userService;
    private final EmailService emailService;

    public SubscriptionConsumer(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @RabbitListener(queues = "subscription-request-queue")
    public void receiver(@Payload String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        NotificationMessage notificationMessage = mapper.readValue(message, NotificationMessage.class);
        for(Long id : notificationMessage.getUsersIds()) {
            User user = userService.findOne(id);
            emailService.sendNewPostNotification(user.getEmail());
        }

    }


}
