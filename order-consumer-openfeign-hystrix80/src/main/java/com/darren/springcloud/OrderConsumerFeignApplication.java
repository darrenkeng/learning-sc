package com.darren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerFeignApplication.class, args);
    }
}
