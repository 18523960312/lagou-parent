package com.lagou.mapper;

import com.lagou.pojo.BOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BOrderMapper {
    public void addBOrder(BOrder bOrder);
}
