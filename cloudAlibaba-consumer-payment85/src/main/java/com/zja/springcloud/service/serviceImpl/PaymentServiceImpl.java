package com.zja.springcloud.service.serviceImpl;

import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author zhujiaao
 * @Date 2020/9/6 16:37
 * @Version 1.0
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult paymentSQL(Long id) {
        return CommonResult.errorMsg("服务降级返回！");
    }
}
