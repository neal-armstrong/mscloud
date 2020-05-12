package per.neal.learn.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import per.neal.learn.entities.CommonResult;
import per.neal.learn.entities.Payment;
import per.neal.learn.service.PaymentService;

import javax.annotation.Resource;

@RestController
public class OrderFeignCtrl {

    @Resource
    private PaymentService paymentService;

    @Value("${server-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping(value = "/consumer/feign/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
