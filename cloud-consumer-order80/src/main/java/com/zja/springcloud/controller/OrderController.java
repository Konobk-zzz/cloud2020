package com.zja.springcloud.controller;


import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Payment;
import com.zja.springcloud.lb.MyLBRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class OrderController {
    public static final String PAYMENT_URL="http://localhost:8001/provider";

    public static final String PAYMENT_Eureka_URL="http://CLOUD-PAYMENT-PROVIDER/provider";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private MyLBRule myLBRule;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/payment/save")
    public CommonResult save(Payment payment){
        return restTemplate.postForObject(PAYMENT_Eureka_URL + "/payment/save",payment,CommonResult.class);
    }

    @RequestMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_Eureka_URL + "/payment/"+id,CommonResult.class);
    }

    @RequestMapping("/payment/getEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_Eureka_URL + "/payment/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return CommonResult.errorMsg("请求失败！");
        }
    }

    @RequestMapping("/payment/lb")
    public CommonResult getMyLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-PROVIDER");
        if(instances==null || instances.size()==0)return CommonResult.error();
        ServiceInstance instance = myLBRule.instances(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/provider/lb",CommonResult.class);
    }

    @GetMapping("/payment/zipkin")
    public String getZipkin(){
        return restTemplate.getForObject(PAYMENT_Eureka_URL + "/payment/zipkin", String.class);
    }
}
