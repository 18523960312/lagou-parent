package com.lagou.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitConsumer {

    @RabbitListener(queues = "q.biz")
    public void getMessage(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload String message){
        System.out.println("消费者接收到的消息: "+message);
//        try {
//            // 手动ack，deliveryTag表示消息的唯一标志，multiple表示是 否是批量确认
//            //channel.basicAck(deliveryTag,false);
//            // 手动拒绝消息。第二个参数表示是否重新入列
//            //channel.basicReject(deliveryTag,true);
//            //System.err.println("已确认消息：" + message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
