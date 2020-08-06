package com.zja.springcloud.service;

import com.zja.springcloud.entity.Payment;

public interface PaymentService {

    Integer savePayment(Payment payment);

    Payment getPayment(Long id);
}
