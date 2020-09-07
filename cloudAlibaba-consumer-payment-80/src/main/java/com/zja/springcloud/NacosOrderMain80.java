package com.zja.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhujiaao
 * @Date 2020/9/4 21:31
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain80.class,args);
    }
}
