package com.lagou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.service.IHelloService;

@Service(version = "1.0.0")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String content) {
        return "say "+content;
    }
}
