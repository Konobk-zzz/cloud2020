package com.zja.springcloud.dao;

import com.zja.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    Integer savePayment(Payment payment);

    Payment getPayment(@Param("id") Long id);
}
