package com.lagou.controller;

import com.lagou.pojo.Artical;
import com.lagou.service.ArticalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artical")
public class ArticalController {

    @Autowired
    private ArticalServiceImpl articalService;

    @RequestMapping("/byId/{id}")
    public Artical byId(@PathVariable String id){
        return articalService.findArticalById(id);
    }
}
