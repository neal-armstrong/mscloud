package per.neal.learn.service.impl;

import org.springframework.stereotype.Component;
import per.neal.learn.service.PaymentHistrixService;

@Component
public class PaymentFallbackService implements PaymentHistrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "------paymentInfo_OK fall back---";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------paymentInfo_TimeOut fall back---";
    }
}
