package com.lagou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String helloController(){
        return "Hello mt";
    }

    @RequestMapping("/info/{userid}")
    public String info(@PathVariable String userid){
        return port +" hello "+userid;
    }

    @RequestMapping("/userInfo/{userid}")
    public String userInfo(@PathVariable String userid){
        return port + " hystrix "+userid;
    }

    @RequestMapping("/feign/{userid}")
    public String feign(@PathVariable String userid){
        return port +" feign "+userid;
    }
}
