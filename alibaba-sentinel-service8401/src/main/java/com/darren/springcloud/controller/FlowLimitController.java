package com.darren.springcloud.controller;

import com.darren.springcloud.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-28
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private IMessageService messageService;

    @GetMapping("/testA")
    public String testA(){
        return "*******testA*******";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info("{}********testB******", Thread.currentThread().getName());
        return "********testB******";
    }

    @GetMapping("testC")
    public String testC() {
        return messageService.info();
    }

    @GetMapping("testD")
    public String testD() {
        return messageService.info();
    }

}
