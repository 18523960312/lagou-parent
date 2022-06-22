package com.test;

import com.lagou.ContractBApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes={ContractBApp.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void test01(){
        List<ServiceInstance> instances = discoveryClient.getInstances("LAGOU-CLOUD-EUREKA-SERVER");
        for (ServiceInstance serviceInstance:instances) {
            System.out.println(serviceInstance.toString());
        }
    }
}
