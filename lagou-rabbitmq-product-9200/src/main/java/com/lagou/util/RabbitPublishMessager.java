package com.lagou.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
@Slf4j
public class RabbitPublishMessager {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String data) throws Exception {
        String exchange = "ex.basic";
        String routingKey = "key.basic";
        Message message = MessageBuilder.withBody(data.getBytes("utf-8")).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        rabbitTemplate.send(exchange,routingKey,message);
    }
}
