package com.lagou.mapper;

import com.lagou.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    public void addUserInfo(UserInfo userInfo);

    public List<UserInfo> queryUserInfoList();
}
