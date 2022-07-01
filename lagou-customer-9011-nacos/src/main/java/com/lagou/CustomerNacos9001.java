package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerNacos9001 {
    public static void main(String[] args) {
        SpringApplication.run(CustomerNacos9001.class,args);
    }
}
