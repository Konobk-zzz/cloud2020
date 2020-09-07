package com.zja.springcloud.controller;

import com.zja.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhujiaao
 * @Date 2020/9/2 22:23
 * @Version 1.0
 */
@RestController
@RequestMapping("/nacos")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
        return CommonResult.successMsg("nacos registry,server-port:"+port+"\t id:"+id);
    }
}
