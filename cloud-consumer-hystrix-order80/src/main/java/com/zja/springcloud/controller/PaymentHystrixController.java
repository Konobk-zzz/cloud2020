package com.zja.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "commonFallback",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
})
public class PaymentHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/ok/{id}")
    public CommonResult paymentInfo_OK(@PathVariable("id") Long id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

//    @HystrixCommand(fallbackMethod = "ExceptionHandler" ,commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/payment/timeout/{id}")
    public CommonResult paymentInfo_Timeout(@PathVariable("id") Long id){
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

    public CommonResult ExceptionHandler(Long id){
        String s="80消费者 == 线程池: "+Thread.currentThread().getName()+" 目标服务繁忙或运行异常, id: "+id+"\t ExceptionHandler";
        return CommonResult.errorMsg(s);
    }

    public String commonFallback(){
        return "调用目标方法超时，或者自身异常！";
    }
}
