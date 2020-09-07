package com.zja.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhujiaao
 * @Date 2020/9/6 15:33
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliPaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(AliPaymentMain9003.class,args);
    }
}
