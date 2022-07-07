package com.lagou.controller;

import com.lagou.pojo.YmlPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Autowired
    private YmlPojo ymlPojo;

    @RequestMapping("/info")
    public String getData(){
        return ymlPojo.getMaqianqian();
    }
}
