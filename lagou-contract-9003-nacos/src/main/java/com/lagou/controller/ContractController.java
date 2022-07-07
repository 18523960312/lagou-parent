package com.lagou.controller;

import com.lagou.pojo.DicInfo;
import com.lagou.service.CustomerFeign;
import com.lagou.service.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class ContractController {
    @Autowired
    private CustomerFeign customerFeign;
    @Autowired
    private QueryServiceImpl queryService;

    @RequestMapping("/info/{id}")
    public String getInfo(@PathVariable("id")String id){
        return customerFeign.getInfo(id);
    }

    @RequestMapping("/dicinfo/{id}")
    public DicInfo getDicInfo(@PathVariable String id){
        return queryService.getById(id);
    }
}
