package per.neal.learn.ctrl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import per.neal.learn.service.PaymentHistrixService;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixCtrl {
    @Resource
    private PaymentHistrixService paymentHistrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHistrixService.paymentInfo_OK(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            // 设置超时处理时间
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
//    @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentHistrixService.paymentInfo_TimeOut(id);
    }


    public String paymentInfo_TimeOutHandler(Integer id) {
        return "我是消费者80，支付系统繁忙，请稍后再试,id:" + id;
    }

    public String paymentGlobalFallbackMethod() {
        return "全局处理器，处理异常，请稍后再试";
    }

}
