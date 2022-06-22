package com.lagou.controller.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service("customerServiceImpl")
public class CustomerServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="hystrixInfo"// 降级的处理方法
             )
    public String hystixTest(String userid) {
        String url = "http://lagou-contract/contract/userInfo/"+userid;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody();
        return body;
    }

    public String hystrixInfo(@PathVariable String userid){
        return "请稍后再试,谢谢!";
    }
}
