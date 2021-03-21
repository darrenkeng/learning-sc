package com.darren.springcloud.service;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-16
 */
public class ServiceB {

    private ServiceA serviceA;

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public ServiceB() {
        System.out.println("ServiceB create finished...");
    }
}
