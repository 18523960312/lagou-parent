package com.test;

import com.lagou.CustomerApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest(classes = {CustomerApp.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void test01(){
        String url = "http://LAGOU-CONTRACT/contract/info/"+1;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response);
    }

    @Test
    public void test02(){
        List<ServiceInstance> instances = discoveryClient.getInstances("lagou-contract");
        for (ServiceInstance s:instances) {
            System.out.println(s);
        }
    }
}
