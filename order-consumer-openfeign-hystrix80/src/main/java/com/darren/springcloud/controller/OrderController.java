package com.darren.springcloud.controller;

import com.darren.springcloud.entities.CommonResult;
import com.darren.springcloud.entities.Payment;
import com.darren.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-22
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "consumer/payment/openfeign/timeout")
    public CommonResult feignTimeout() {
        return paymentFeignService.feignTimeout();
    }

    @GetMapping(value = "consumer/payment/hystrix/ok")
    public CommonResult paymentInfoOk() {
        return paymentFeignService.paymentInfoOk();
    }

    @GetMapping(value = "consumer/payment/hystrix/timeout")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public CommonResult paymentInfoTimeout() {
        return paymentFeignService.paymentInfoTimeout();
    }

    public CommonResult paymentInfoTimeoutHandler() {
        return new CommonResult(200, "success", "paymentInfoTimeoutHandler");
    }

}
