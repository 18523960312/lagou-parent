package com.lagou;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "queue.basic",containerFactory="singleListenerContainer")
    public void rabbitmqConsumer(@Payload byte[] msg){
        String message = new String(msg);
        log.info("接收到的消息:{}",message);
    }
}
