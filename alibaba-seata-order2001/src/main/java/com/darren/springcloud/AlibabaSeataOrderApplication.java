package com.darren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-03
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaSeataOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaSeataOrderApplication.class, args);
    }
}
