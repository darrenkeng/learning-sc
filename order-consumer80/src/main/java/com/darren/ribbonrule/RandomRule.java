package com.darren.ribbonrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-23
 */
@Configuration
public class RandomRule {

    @Bean
    public IRule getRule(){
        return new com.netflix.loadbalancer.RandomRule();
    }
}
