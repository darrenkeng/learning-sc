package com.darren.springcloud.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.stream.messaging.Source.OUTPUT;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-28
 */
public interface CustomSource {

    @Output(OUTPUT)
    MessageChannel output();

    String OUTPUT2 = "output2";

    @Output(OUTPUT2)
    MessageChannel output2();
}
