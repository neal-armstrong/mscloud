package per.neal.learn.service;

import org.springframework.stereotype.Component;
import per.neal.learn.entities.CommonResult;
import per.neal.learn.entities.Payment;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回！,------PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
