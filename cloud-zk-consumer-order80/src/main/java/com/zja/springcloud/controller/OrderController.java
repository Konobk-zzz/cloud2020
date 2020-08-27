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

    public static final String PAYMENT_Eureka_URL="http://cloud-provider-payment/provider";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/payment/save")
    public CommonResult save(Payment payment){
        return restTemplate.postForObject(PAYMENT_Eureka_URL + "/payment/save",payment,CommonResult.class);
    }

    @RequestMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_Eureka_URL + "/payment/"+id,CommonResult.class);
    }

    @GetMapping("/payment")
    public CommonResult get(){
        return restTemplate.getForObject(PAYMENT_Eureka_URL + "/payment/zk",CommonResult.class);
    }
}
