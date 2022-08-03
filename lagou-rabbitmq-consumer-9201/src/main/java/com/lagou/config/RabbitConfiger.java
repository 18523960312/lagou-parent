package com.lagou.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfiger {
    @Bean
    public Queue basicQueue(){
        return new Queue("q.biz", true);
    }

    @Bean
    public Exchange basicExchange(){
        return new DirectExchange("ex.biz", true, false);
    }

    @Bean
    public Binding basicBinding(){
        return BindingBuilder.bind(basicQueue()).to(basicExchange()).with("key.biz").noargs();
    }
}
