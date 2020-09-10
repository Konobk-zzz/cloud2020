package com.zja.springcloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhujiaao
 * @Date 2020/9/7 22:28
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan({"com.zja.springcloud.dao"})
@EnableAutoDataSourceProxy(useJdkProxy = true)
public class SeataOrderMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2001.class,args);
    }
}
