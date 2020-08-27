package com.zja.springcloud.service;

import com.zja.springcloud.dao.PaymentMapper;
import com.zja.springcloud.entity.Payment;
import javax.annotation.Resource;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    PaymentMapper paymentMapper;

    @Override
    public Integer savePayment(Payment payment) {
        return paymentMapper.savePayment(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentMapper.getPayment(id);
    }
}
