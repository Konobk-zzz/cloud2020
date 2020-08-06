package com.zja.springcloud.controller;

import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import com.zja.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/provider")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        if (payment==null){
            return CommonResult.error();
        }
        return CommonResult.successData(payment);
    }

    @PostMapping("/payment/save")
    public CommonResult savePayment(@RequestBody Payment payment){
        Integer result = paymentService.savePayment(payment);
        if (result==0){
            return CommonResult.error();
        }
        return CommonResult.success();
    }
}
