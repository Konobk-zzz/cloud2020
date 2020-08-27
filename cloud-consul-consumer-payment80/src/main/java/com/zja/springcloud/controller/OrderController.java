package com.zja.springcloud.controller;

import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String PAYMENT_Eureka_URL="http://cloud-provider-consul-payment/provider";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consul/payment")
    public CommonResult get(){
        return restTemplate.getForObject(PAYMENT_Eureka_URL + "/payment",CommonResult.class);
    }
}
