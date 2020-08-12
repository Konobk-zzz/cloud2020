package com.zja.springcloud.controller;

import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import com.zja.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    String port;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        if (payment==null){
            return CommonResult.error();
        }
        return CommonResult.successMsgData(port,payment);
    }

    @PostMapping("/payment/save")
    public CommonResult savePayment(@RequestBody Payment payment){
        Integer result = paymentService.savePayment(payment);
        if (result==0){
            return CommonResult.error();
        }
        return CommonResult.success();
    }

    @GetMapping("/payment/discovery")
    public Object getDiscoveryIfm(){
        List<String> services = discoveryClient.getServices();
        for (String e:services){
            log.info("============service=="+e);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-PROVIDER");
        for (ServiceInstance e:instances){
            log.info(e.getInstanceId()+"\t"+e.getHost()+"\t"+e.getPort()+"\t"+e.getUri());
        }
        return discoveryClient;
    }
}
