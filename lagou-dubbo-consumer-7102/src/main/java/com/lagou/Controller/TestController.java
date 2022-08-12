package com.lagou.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.service.IHelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Reference(version = "1.0.0")
    private IHelloService helloService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name")String name){
        return helloService.sayHello(name);
    }

}
