package com.darren.springcloud.hander;

import com.darren.springcloud.stream.CustomSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-28
 */
@Component
@EnableBinding(CustomSink.class)
@Slf4j
public class MessageReceiveHandler2 {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(CustomSink.SINK_INPUT_2)
    public void input(Message<String> message) {
        log.info("***********消费者({})接收到消息：{}", serverPort, message.getPayload());
    }
}
