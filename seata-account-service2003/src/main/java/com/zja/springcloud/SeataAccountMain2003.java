package com.zja.springcloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhujiaao
 * @Date 2020/9/9 22:43
 * @Version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoDataSourceProxy(useJdkProxy = true)
@MapperScan({"com.zja.springcloud.dao"})
public class SeataAccountMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain2003.class,args);
    }
}
