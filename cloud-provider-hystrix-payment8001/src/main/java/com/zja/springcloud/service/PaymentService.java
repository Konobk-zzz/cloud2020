package com.zja.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zja.springcloud.entity.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Long id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_OK, id: "+id+"\t success";
    }

    @HystrixCommand(fallbackMethod = "ExceptionHandler" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfo_Timeout(Long id){
        int seconds=3;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_Timeout, id: "+id+"\t success 耗时"+seconds+"秒";
    }

    public String ExceptionHandler(Long id){
        return "线程池: "+Thread.currentThread().getName()+" 系统繁忙或运行异常, id: "+id+"\t ExceptionHandler";
    }

    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        if(id<0){
            throw new RuntimeException("id不能小于0！");
        }
        String s = UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t 调用成功,流水号："+s;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id){
        return "触发Fallback！";
    }
}
