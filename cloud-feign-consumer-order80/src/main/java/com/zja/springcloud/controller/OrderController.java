package com.zja.springcloud.controller;


import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import com.zja.springcloud.service.PaymentFeignService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/save")
    public CommonResult save(Payment payment){
        return paymentFeignService.savePayment(payment);
    }

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }

    @GetMapping("/payment/timeout")
    public CommonResult timeOutTest(){
        return paymentFeignService.timeOutTest();
    }
}
