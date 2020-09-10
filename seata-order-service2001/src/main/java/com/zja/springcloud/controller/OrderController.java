package com.zja.springcloud.controller;


import com.zja.springcloud.entity.CommonResult;
import com.zja.springcloud.entity.Order;
import com.zja.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-26 15:24
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return CommonResult.successMsg("订单创建成功");
    }
}
