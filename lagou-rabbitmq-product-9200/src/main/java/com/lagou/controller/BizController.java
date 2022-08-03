package com.lagou.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class BizController {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean flag, String cause) {
                if(flag){
                    try{
                        System.out.println("消息确认: id="+correlationData.getId()+"; "+new String(correlationData.getReturnedMessage().getBody(),"utf-8"));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }else{
                    System.out.println("失败原因:"+cause);
                }
            }
        });
    }

    @RequestMapping("/biz")
    public String dobiz() throws UnsupportedEncodingException, InterruptedException {
        MessageProperties properties = new MessageProperties();
        properties.setCorrelationId("12345");
        properties.setConsumerTag("msg2");
        properties.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
        properties.setContentEncoding("utf-8");

        CorrelationData cd = new CorrelationData();
        cd.setId("msg2");
        cd.setReturnedMessage(new Message("这是msg1的相应".getBytes("utf-8"), null));
        Message message = new Message("这是等待确认的消息".getBytes("utf-8"),properties);
        rabbitTemplate.sendAndReceive("ex.biz", "key.biz", message, cd);
        return "ok";
    }

    @RequestMapping("/bizfalse")
    public String dobizfalse() throws UnsupportedEncodingException {
        MessageProperties properties = new MessageProperties();
        properties.setCorrelationId("123456");
        properties.setConsumerTag("msg3");
        properties.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
        properties.setContentEncoding("utf-8");

        CorrelationData cd = new CorrelationData();
        cd.setId("msg3");
        cd.setReturnedMessage(new Message("这是msg1的相应".getBytes("utf-8"), null));
        Message message = new Message("这是等待确认的消息".getBytes("utf-8"),properties);
        rabbitTemplate.sendAndReceive("q.bizfalse", "key.bizfalse", message, cd);
        return "ok";
    }
}
