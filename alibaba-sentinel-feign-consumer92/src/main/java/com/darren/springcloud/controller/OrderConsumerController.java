package com.darren.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.darren.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-02
 */
@RestController
public class OrderConsumerController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    /**
     * exceptionsToIgnore callback 时忽略的异常
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/nacos/{id}")
    @SentinelResource(value = "payment", fallback = "fallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {
                    RuntimeException.class
            })
    public String get(@PathVariable("id") Integer id) {
        if (id < 1) {
            throw new RuntimeException("id 不能为负数");
        }
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * 使用 fallback 时，Throwable 非必选项
     *
     * @param id
     * @param e
     * @return
     */
    public String fallback(Integer id, Throwable e) {
        return "fallback";
    }

    /**
     * 不使用 blockHandler 时，由 fallback 处理
     * 使用 blockHandler 时，BlockException 为必选项
     *
     * @param id
     * @param blockException
     * @return
     */
    public String blockHandler(@PathVariable("id") Integer id, BlockException blockException) {
        return "blockHandler";
    }
}
