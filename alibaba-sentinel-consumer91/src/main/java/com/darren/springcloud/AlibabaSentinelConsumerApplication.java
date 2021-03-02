package com.darren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaSentinelConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelConsumerApplication.class, args);
    }
}
