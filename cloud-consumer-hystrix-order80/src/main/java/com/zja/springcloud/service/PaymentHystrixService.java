package com.zja.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zja.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentHystrixFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/provider/payment/hystrix/ok/{id}")
    CommonResult paymentInfo_OK(@PathVariable("id") Long id);


    @GetMapping("/provider/payment/hystrix/timeout/{id}")
    CommonResult paymentInfo_Timeout(@PathVariable("id") Long id);

}
