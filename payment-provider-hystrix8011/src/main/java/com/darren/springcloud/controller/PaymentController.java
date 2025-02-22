package com.darren.springcloud.controller;

import com.darren.springcloud.entities.CommonResult;
import com.darren.springcloud.entities.Payment;
import com.darren.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-22
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.createPayment(payment);
        if (result > 0) {
            return new CommonResult(200, "success" + serverPort, result);
        } else {
            return new CommonResult(500, "error", null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (Objects.nonNull(payment)) {
            return new CommonResult(200, "success" + serverPort, payment);
        } else {
            return new CommonResult(500, "error", null);
        }
    }

    @GetMapping(value = "payment/discoveryClient")
    public CommonResult discoveryClient() {
        List<String> services = discoveryClient.getServices();
        services.forEach((t) -> {
            log.info(t);

            List<ServiceInstance> instances = discoveryClient.getInstances(t);
            instances.forEach((i) -> log.info(i.getInstanceId() + "\t" + i.getUri()));
        });
        return new CommonResult(200, "success", discoveryClient);
    }

    @GetMapping(value = "payment/openfeign/timeout")
    public CommonResult feignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200, "success", null);
    }

    @GetMapping(value = "payment/hystrix/ok")
    public CommonResult paymentInfoOk() {
        return new CommonResult(200, "success", paymentService.paymentInfoOk());
    }

    @GetMapping(value = "payment/hystrix/timeout")
    public CommonResult paymentInfoTimeout() {
        return new CommonResult(200, "success", paymentService.paymentInfoTimeout());
    }

    // =========服务熔断
    @GetMapping(value = "payment/circuit/{id}")
    public CommonResult getPaymentCircuitById(@PathVariable("id") Long id) {
        return new CommonResult(200, "success" + serverPort, paymentService.paymentCircuitBreaker(id));
    }

}