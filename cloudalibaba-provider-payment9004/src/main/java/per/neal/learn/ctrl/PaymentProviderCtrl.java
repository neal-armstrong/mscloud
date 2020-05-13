package per.neal.learn.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import per.neal.learn.entities.CommonResult;
import per.neal.learn.entities.Payment;

import java.util.HashMap;

@RestController
public class PaymentProviderCtrl {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put(1L, new Payment(1L, "74A======================="));
        hashMap.put(2L, new Payment(2L, "84A======================="));
        hashMap.put(3L, new Payment(3L, "94A======================="));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort:" + serverPort, payment);
        return result;
    }
}
