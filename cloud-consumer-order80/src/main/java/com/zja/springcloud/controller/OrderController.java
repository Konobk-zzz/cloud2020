package com.zja.springcloud.controller;

import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL="http://localhost:8001/provider";

    public static final String PAYMENT_Eureka_URL="http://CLOUD-PAYMENT-PROVIDER/provider";

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
}
