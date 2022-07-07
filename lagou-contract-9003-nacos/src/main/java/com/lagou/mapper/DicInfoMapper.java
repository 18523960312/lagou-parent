package com.lagou.mapper;

import com.lagou.pojo.DicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DicInfoMapper {

    @Select("select * from dic_info where id=#{id}")
    public DicInfo getById(String id);
}
