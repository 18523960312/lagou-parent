package com.lagou.service;

import com.lagou.mapper.DicInfoMapper;
import com.lagou.pojo.DicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl {
    @Autowired
    private DicInfoMapper dicInfoMapper;

    public DicInfo getById(String id){
        return dicInfoMapper.getById(id);
    }
}
