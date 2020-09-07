package com.zja.springcloud.service;

import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.service.serviceImpl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhujiaao
 * @Date 2020/9/6 16:35
 * @Version 1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id);
}
