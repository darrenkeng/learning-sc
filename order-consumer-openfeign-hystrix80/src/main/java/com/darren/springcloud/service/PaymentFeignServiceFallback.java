package com.darren.springcloud.service;

import com.darren.springcloud.entities.CommonResult;
import com.darren.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-02-23
 */
@Component
public class PaymentFeignServiceFallback implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return commonResult();
    }

    @Override
    public CommonResult feignTimeout() {
        return commonResult();
    }

    @Override
    public CommonResult paymentInfoOk() {
        return commonResult();
    }

    @Override
    public CommonResult paymentInfoTimeout() {
        return commonResult();
    }

    public CommonResult commonResult() {
        return new CommonResult(500, "global fallback");
    }
}
