package com.darren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPaymentProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentProviderApplication.class, args);
    }
}
