package com.lagou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes={RabbitmqApp.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitTest {

//    @Autowired
//    private RabbitPublishMessager rabbitPublishMessager;
//
//    @Test
//    public void test01(){
//        try {
//            rabbitPublishMessager.sendMessage("haha xw");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
