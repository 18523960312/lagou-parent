package com.lagou.controller;

import com.lagou.controller.service.ContractFeign;
import com.lagou.controller.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customerInfo")
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/info")
    public String info(){
        return "info";
    }

    @GetMapping("/contractInfo/{userid}")
    public String contractInfo(@PathVariable String userid){
        String url = "http://lagou-contract/contract/info/"+userid;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String body = response.getBody();
        return body;
    }

    @GetMapping("/hystrix/{userid}")
    public String hystixTest(@PathVariable String userid){
        String response = customerService.hystixTest(userid);
        return response;
    }

    @Autowired
    private ContractFeign contractFeign;

    @GetMapping("/feigntest/{userid}")
    public String feigntest(@PathVariable String userid){
        return contractFeign.feign(userid);
    }
}
