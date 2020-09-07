package com.zja.springcloud.controller;

import com.zja.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zhujiaao
 * @Date 2020/9/4 21:34
 * @Version 1.0
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/payment/nacos/{id}")
    public CommonResult paymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverURL+"/nacos/payment/"+id,CommonResult.class);
    }
}
