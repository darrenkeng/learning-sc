package com.darren.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-27
 */
@Configuration
public class RouteLocatorConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();
    }

}
