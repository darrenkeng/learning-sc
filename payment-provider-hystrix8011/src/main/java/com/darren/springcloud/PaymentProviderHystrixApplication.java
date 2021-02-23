package com.darren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: Darren Keng
 * @company: wonhigh
 * @create: 2021-02-22
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentProviderHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderHystrixApplication.class, args);
    }
}
