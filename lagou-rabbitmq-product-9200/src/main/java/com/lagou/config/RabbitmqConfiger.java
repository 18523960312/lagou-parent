package com.lagou.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitmqConfiger {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    /**
     * 创建rabbitTemplate,并且设置消息发送的成功与否的确认机制
     */
    @Bean(name = "rabbitMQ")
    public RabbitTemplate rabbitTemplate(){
        //生产者确认消息是否发送过去
        connectionFactory.setPublisherConfirms(true);

        //生产者发送消息后需要,反馈消息
        connectionFactory.setPublisherReturns(true);

        //构建rabbitTemplate操作模板
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // mandatory：交换器无法根据自身类型和路由键找到一个符合条件的队列时的处理方式
        // true：RabbitMQ会调用Basic.Return命令将消息返回给生产者
        //false：RabbitMQ会把消息直接丢弃
        rabbitTemplate.setMandatory(true);

        //生产者发送消息成功后,如果发送成功,则处理下面逻辑
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("发送消息成功:correlationData={};ack={};cause={}",correlationData,ack,cause);
            }
        });

        //生产者发送消息失败后的回调函数
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
            }
        });

        return rabbitTemplate;
    }

    /**
     * 设置队列
     * @return
     */
    @Bean(name = "basicQueue")
    public Queue basicQueue(){
        return new Queue("queue.basic",true);//设置为持久化队列
    }

    /**
     * 创建交换器
     */
    @Bean(name = "basicExchange")
    public Exchange basicExchange(){
        return new DirectExchange("ex.basic", true, false);
    }

    /**
     * 设置绑定关系
     */
    @Bean
    public Binding basicBinding(){
        return BindingBuilder.bind(basicQueue()).to(basicExchange()).with("key.basic").noargs();
    }

    /**
     * 设置单个消费者
     * 消费者的Ack确认机制为AUTO
     */
    @Bean(name = "singleListenerContainer")
    public SimpleRabbitListenerContainerFactory listenerContainerFactory() {
        SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setMessageConverter(new Jackson2JsonMessageConverter());

        // 设置消费者的个数
        containerFactory.setConcurrentConsumers(1);
        // 设置消费者的最大值
        containerFactory.setMaxConcurrentConsumers(1);
        // 设置消费者每次拉取的消息数量，即消费者一次拉取几条消息
        containerFactory.setPrefetchCount(1);

        // 设置确认消息模型为自动确认消费AUTO，目的是防止消息丢失和消息被重复消费
        containerFactory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return containerFactory;
    }

}
