package com.darren.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.darren.springcloud.dao.PaymentDao;
import com.darren.springcloud.entities.Payment;
import com.darren.springcloud.service.PaymentService;
import com.netflix.hystrix.HystrixCommandProperties;
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

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            // 开始服务熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后触发熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        return Thread.currentThread().getName() + "\t 调用成功。id = " + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreakerHandler(Long id) {
        return Thread.currentThread().getName() + "\t paymentCircuitBreakerHandler";
    }


    public String paymentInfoTimeoutHandler() {
        return Thread.currentThread().getName() + "\t paymentInfoTimeoutHandler";
    }
}
