package com.lagou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${a}")
    String a;
    @Value("${b}")
    String b;

    @RequestMapping("/info")
    public String info(){
        return "a="+a+";b="+b;
    }
}
