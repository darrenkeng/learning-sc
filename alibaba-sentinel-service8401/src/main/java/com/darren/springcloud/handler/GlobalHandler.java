package com.darren.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-01
 */
public class GlobalHandler {

    public static String handler(BlockException exception){
        return "GlobalHandler";
    }
}
