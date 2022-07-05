package com.lagou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
@RefreshScope
public class NacosController {
    @Value("${maqianqian}")
    private String maqianqian;

    @RequestMapping("/info")
    public String getData(){
        return maqianqian;
    }
}
