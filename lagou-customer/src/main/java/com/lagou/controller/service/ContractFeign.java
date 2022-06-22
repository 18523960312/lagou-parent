package com.lagou.controller.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "lagou-contract")
public interface ContractFeign {

    @RequestMapping("/contract/feign/{userid}")
    public String feign(@PathVariable String userid);


}
