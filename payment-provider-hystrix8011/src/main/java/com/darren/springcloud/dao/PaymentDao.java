package com.darren.springcloud.dao;

import com.darren.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int createPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
