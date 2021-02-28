package com.darren.springcloud.service.impl;

import com.darren.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.time.ZonedDateTime;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-28
 */
@EnableBinding(Source.class)
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public void send() {
        output.send(MessageBuilder.withPayload(ZonedDateTime.now()).build());
    }
}
