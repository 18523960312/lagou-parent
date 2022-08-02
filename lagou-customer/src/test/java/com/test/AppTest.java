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

    /**
     * 1.将数组中的0放到末尾
     * [0,123,3,0,987,1]
     */
    public static void main1(String[] args) {
        int[] nums = new int[]{0,123,3,0,987,1};
        int[] anInt = getInt(nums);
        for (int i = 0; i < anInt.length; i++) {
            System.out.println(anInt[i]);
        }
    }

    private static int[] getInt(int[] nums){
        int i = 0;
        for ( int num:nums ) {
            if(num!=0){
                nums[i++]=num;
            }
        }

        while(i<nums.length){
            nums[i++]=0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int oldCapacity = 8;
        int newCapacityold= oldCapacity >> 1;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacityold+"==="+newCapacity);
    }
}
