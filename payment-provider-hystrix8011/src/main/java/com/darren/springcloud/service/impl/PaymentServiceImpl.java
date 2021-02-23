package com.darren.springcloud.service.impl;

import com.darren.springcloud.dao.PaymentDao;
import com.darren.springcloud.entities.Payment;
import com.darren.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public String paymentInfoOk() {
        return Thread.currentThread().getName() + "\t paymentInfoOk";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 10 / 0;
        return Thread.currentThread().getName() + "\t paymentInfoTimeout";
    }

    public String paymentInfoTimeoutHandler() {
        return Thread.currentThread().getName() + "\t paymentInfoTimeoutHandler";
    }
}
