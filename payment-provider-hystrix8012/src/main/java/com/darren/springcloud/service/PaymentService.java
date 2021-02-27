package com.darren.springcloud.service;

import com.darren.springcloud.entities.Payment;

public interface PaymentService {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);

    String paymentInfoOk();

    String paymentInfoTimeout();

    String paymentCircuitBreaker(Long id);
}
