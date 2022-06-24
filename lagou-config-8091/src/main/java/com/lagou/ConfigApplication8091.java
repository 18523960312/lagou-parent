package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer //配置服务
public class ConfigApplication8091 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication8091.class, args);
    }
}
