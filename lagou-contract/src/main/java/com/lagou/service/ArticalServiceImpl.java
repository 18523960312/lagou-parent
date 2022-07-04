package com.lagou.service;

import com.lagou.Mapper.ArticalMapper;
import com.lagou.pojo.Artical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticalServiceImpl {
    @Autowired
    private ArticalMapper articalMapper;

    public Artical findArticalById(String id){
        return articalMapper.getArtical(id);
    }
}
