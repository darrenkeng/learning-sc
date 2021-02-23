package com.darren.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-23
 */
@Configuration
public class feignConfigraction {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
