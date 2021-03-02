package com.darren.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
    private RestTemplate restTemplate;

    @Value("${payment-provider-url}")
    private String paymentProviderUrl;

    @GetMapping("/consumer/payment/nacos/{id}")
    @SentinelResource(value = "payment", fallback = "fallback", blockHandler = "blockHandler")
    public String get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(paymentProviderUrl + "/payment/nacos/" + id, String.class);
    }

    public String fallback(Integer id){
        return "fallback";
    }

    public String blockHandler(@PathVariable("id") Integer id, BlockException blockException){
        return "blockHandler";
    }
}
