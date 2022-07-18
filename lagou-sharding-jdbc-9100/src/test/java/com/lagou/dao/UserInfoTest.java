package com.lagou.dao;

import com.lagou.mapper.BOrderMapper;
import com.lagou.mapper.UserInfoMapper;
import com.lagou.pojo.BOrder;
import com.lagou.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BOrderMapper bOrderMapper;

    /**
     * 分库测试
     */
    @Test
    public void test01(){
        for (int i=1; i<10; i++) {
            UserInfo userInfo = new UserInfo();
           // userInfo.setId(new Long(i));
            userInfo.setName("a"+i);
            userInfo.setSex(i%1);
            userInfoMapper.addUserInfo(userInfo);
        }
    }

    /**
     * 分库分表测试
     */
    @Test
    @Repeat(100)
    public void test02(){
        BOrder bOrder = new BOrder();
        Random random = new Random();
        int companyId = random.nextInt(20);
        int userid = random.nextInt(200);
        bOrder.setUserId(userid);
        bOrder.setCompanyId(companyId);
        bOrder.setName("a");
        bOrderMapper.addBOrder(bOrder);
    }
}
