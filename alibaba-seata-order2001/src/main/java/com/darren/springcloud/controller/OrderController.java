package com.darren.springcloud.controller;

import com.darren.springcloud.entities.CommonResult;
import com.darren.springcloud.entities.Order;
import com.darren.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-04
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
