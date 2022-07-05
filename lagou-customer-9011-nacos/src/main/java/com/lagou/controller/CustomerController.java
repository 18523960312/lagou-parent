package com.lagou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/info/{id}")
    public String getInfo(@PathVariable("id") String id){
        return "hi" + id+" i am "+port;
    }
}
