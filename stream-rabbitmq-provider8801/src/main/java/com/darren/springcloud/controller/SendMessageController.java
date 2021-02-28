package com.darren.springcloud.controller;

import com.darren.springcloud.service.IMessageProvider;
import com.darren.springcloud.service.IMessageProvider2;
import com.darren.springcloud.service.impl.MessageProvider2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-28
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @Autowired
    private MessageProvider2 messageProvider2;

    @GetMapping("send")
    public void send(){
        messageProvider.send();
    }

    @GetMapping("send2")
    public void send2(){
        messageProvider2.send();
    }

}
