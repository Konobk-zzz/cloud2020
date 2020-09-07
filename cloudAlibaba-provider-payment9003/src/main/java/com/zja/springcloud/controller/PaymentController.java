package com.zja.springcloud.controller;

import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhujiaao
 * @Date 2020/9/6 15:34
 * @Version 1.0
 */
@RestController
public class PaymentController {

    public static Map<Long, Payment> map = new HashMap<>();
    static {
        map.put(1L,new Payment(1L,"11111111"));
        map.put(2L,new Payment(2L,"22222222"));
        map.put(3L,new Payment(3L,"33333333"));
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/{id}")
    public CommonResult paymentSQL(@PathVariable("id")Long id){
        return CommonResult.successMsgData("from mysql， port:"+port,map.get(id));
    }
}
