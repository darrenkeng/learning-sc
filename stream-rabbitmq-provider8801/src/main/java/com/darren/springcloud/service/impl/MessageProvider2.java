package com.darren.springcloud.service.impl;

import com.darren.springcloud.service.IMessageProvider;
import com.darren.springcloud.stream.CustomSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-28
 */
@EnableBinding(CustomSource.class)
public class MessageProvider2{

    @Autowired
    private CustomSource source;

    public void send() {
        source.output2().send(MessageBuilder.withPayload(ZonedDateTime.now()).build());
    }
}
