package com.zja.springcloud.controller;


import com.zja.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/provider")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    String port;


    @GetMapping("/payment")
    public CommonResult zkTest(){
        return CommonResult.successData("consul:"+port+"--"+ UUID.randomUUID().toString());
    }

}
