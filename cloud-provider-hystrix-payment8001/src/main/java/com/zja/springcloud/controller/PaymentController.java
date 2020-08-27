package com.zja.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/provider")
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public CommonResult paymentInfo_OK(@PathVariable("id") Long id){
        String s = paymentService.paymentInfo_OK(id);
        log.info("********paymentInfo_OK=======return:"+s);
        return CommonResult.successData(s);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public CommonResult paymentInfo_Timeout(@PathVariable("id") Long id){
        String s = paymentService.paymentInfo_Timeout(id);
        log.info("********paymentInfo_Timeout=======return:"+s);
        return CommonResult.successData(s);
    }

    @GetMapping("/payment/hystrix/break/{id}")
    public CommonResult paymentInfo_CircuitBreaker(@PathVariable("id") Long id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("********paymentInfo_Timeout=======return:"+s);
        return CommonResult.successData(s);
    }
}
