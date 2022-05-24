package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //注册中心服务的标识
public class LagouEurekaServer8766 {

    public static void main(String[] args) {
        SpringApplication.run(LagouEurekaServer8766.class, args);
    }
}
