package com.darren.springcloud.service;

import com.darren.springcloud.entities.CommonResult;
import com.darren.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-23
 */
@Component
@FeignClient(value = "alibaba-payment-provider")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/nacos/{id}")
    String getPaymentById(@PathVariable("id") Integer id);

}
