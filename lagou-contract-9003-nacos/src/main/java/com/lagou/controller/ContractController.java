package com.lagou.controller;

import com.lagou.service.CustomerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class ContractController {
    @Autowired
    private CustomerFeign customerFeign;

    @RequestMapping("/info/{id}")
    public String getInfo(@PathVariable("id")String id){
        return customerFeign.getInfo(id);
    }
}
