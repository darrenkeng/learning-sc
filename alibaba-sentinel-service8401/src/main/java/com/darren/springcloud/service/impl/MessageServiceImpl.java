package com.darren.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.darren.springcloud.service.IMessageService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-01
 */
@Service
public class MessageServiceImpl implements IMessageService {

    @Override
    @SentinelResource(value = "info", fallback = "fallback")
    public String info() {
        return "MessageServiceImpl";
    }

    public String fallback() {
        return "fallback";
    }
}
