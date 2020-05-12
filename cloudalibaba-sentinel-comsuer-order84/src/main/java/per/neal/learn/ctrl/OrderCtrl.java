package per.neal.learn.ctrl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import per.neal.learn.entities.CommonResult;
import per.neal.learn.entities.Payment;

import javax.annotation.Resource;


@RestController
public class OrderCtrl {

    @Resource
    private RestTemplate restTemplate;

    public static final String SERVICE_URL = "http://cloudalibaba-provider-payment";

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (result == null) {
            throw new NullPointerException("没有对应数据，空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "异常handlerFallback,exception内容" + e.getMessage(), payment);
    }

    public CommonResult<Payment> blockHandler(Long id, BlockException e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "blockHandler-sentinel,exception内容" + e.getMessage(), payment);
    }
}
