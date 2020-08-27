package com.zja.springcloud.service;

import com.zja.springcloud.entity.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService{

    @Override
    public CommonResult paymentInfo_OK(Long id) {
        return CommonResult.errorMsg("paymentInfo_OK 目标服务宕机！");
    }

    @Override
    public CommonResult paymentInfo_Timeout(Long id) {
        return CommonResult.errorMsg("paymentInfo_Timeout 目标服务宕机！");
    }
}
