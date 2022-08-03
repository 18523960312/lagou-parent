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

    /**
     * 设置队列
     * @return
     */
    @Bean(name = "basicQueue")
    public Queue basicQueue(){
        return new Queue("q.biz",true);//设置为持久化队列
    }

    /**
     * 创建交换器
     */
    @Bean(name = "basicExchange")
    public Exchange basicExchange(){
        return new DirectExchange("ex.biz", true, false);
    }

    /**
     * 设置绑定关系
     */
    @Bean
    public Binding basicBinding(){
        return BindingBuilder.bind(basicQueue()).to(basicExchange()).with("key.biz").noargs();
    }

}
