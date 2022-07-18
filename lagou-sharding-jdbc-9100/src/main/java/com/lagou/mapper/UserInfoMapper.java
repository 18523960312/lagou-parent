package com.lagou.mapper;

import com.lagou.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    public void addUserInfo(UserInfo userInfo);
}
