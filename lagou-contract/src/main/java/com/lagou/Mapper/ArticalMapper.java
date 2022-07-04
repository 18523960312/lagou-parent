package com.lagou.Mapper;

import com.lagou.pojo.Artical;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticalMapper {

    @Select("select * from t_article where id = #{id}")
    public Artical getArtical(String id);
}
