package com.zja.springcloud.service;

import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "cloud-payment-provider")
public interface PaymentFeignService {
    @GetMapping("/provider/payment/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);

    @PostMapping("/provider/payment/save")
    CommonResult savePayment(@RequestBody Payment payment);

    @PostMapping("/provider/timeout")
    CommonResult timeOutTest();
}
