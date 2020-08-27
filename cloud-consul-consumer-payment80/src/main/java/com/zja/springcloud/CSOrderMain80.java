package com.zja.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CSOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(CSOrderMain80.class,args);
    }
}
