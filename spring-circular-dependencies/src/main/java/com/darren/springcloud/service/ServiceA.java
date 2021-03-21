package com.darren.springcloud.service;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-16
 */
public class ServiceA {

    private ServiceB serviceB;

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public ServiceA() {
        System.out.println("ServiceA create finished...");
    }
}
