package per.neal.learn.ctrl;

import per.neal.learn.entities.CommonResult;
import per.neal.learn.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    public RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("+++++++++++++参数：{}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
