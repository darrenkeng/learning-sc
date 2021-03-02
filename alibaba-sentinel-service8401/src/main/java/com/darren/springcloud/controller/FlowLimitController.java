package com.darren.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.darren.springcloud.handler.GlobalHandler;
import com.darren.springcloud.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testE")
    public String testE(){
        log.info("{}********testE******", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "********testE******";
    }

    @GetMapping("/testF")
    public String testF(){
        int i = 10/0;
        return "********testF******";
    }

    @GetMapping("/testG")
    @SentinelResource(value = "testG", fallback = "testGHandler")
    public String testG(@RequestParam(value = "p1", required = false) String p1,
                        @RequestParam(value = "p2", required = false) String p2){
//        int age = 10/0;
        return "********testG******";
    }

    public String testGHandler(String p1, String p2){
        return "********testGHandler******";
    }

    @GetMapping("/testH")
    @SentinelResource(value = "testH", blockHandlerClass = GlobalHandler.class, blockHandler = "handler")
    public String testH(@RequestParam(value = "p1", required = false) String p1){
        return "********testH******";
    }

}
