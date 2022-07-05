package com.lagou.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(name = "lagou-customer")
public interface CustomerFeign {

    @RequestMapping("/customer/info/{id}")
    public String getInfo(@PathVariable("id") String id);
}
