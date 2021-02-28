package com.darren.springcloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomSink {
    String SINK_INPUT_2 = "input2";

    @Input(SINK_INPUT_2)
    SubscribableChannel input2();
}