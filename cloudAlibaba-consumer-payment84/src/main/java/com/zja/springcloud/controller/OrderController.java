package com.zja.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zhujiaao
 * @Date 2020/9/6 15:53
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult fallback(@PathVariable("id") Long id){

        CommonResult result = restTemplate.getForObject(serverUrl + "/payment/" + id, CommonResult.class);

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常！");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException,该Id没有对应记录！");
        }
        return result;
    }

    public CommonResult handlerFallback(Long id,Throwable e){
        Payment payment = new Payment(id, "null");
        return CommonResult.successMsgData("方法执行异常，当前处于handlerFallback",payment);
    }

    public CommonResult blockHandler(Long id, BlockException e){
        Payment payment = new Payment(id, "null");
        return CommonResult.successMsgData("方法限流，blockFallback",payment);
    }
}
