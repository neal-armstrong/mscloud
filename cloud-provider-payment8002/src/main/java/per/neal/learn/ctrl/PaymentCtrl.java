package per.neal.learn.ctrl;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import per.neal.learn.entities.CommonResult;
import per.neal.learn.entities.Payment;
import per.neal.learn.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentCtrl {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    public String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int status = paymentService.create(payment);
        log.info("*********插入结果:{}", status);

        if (status > 0) {
            return new CommonResult<>(200, "success,server port:" + serverPort, status);
        } else {
            return new CommonResult<>(444, "error", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********查询结果:{ }", payment);
        if (payment != null) {
            return new CommonResult<>(200, "success,server port:" + serverPort, payment);
        }
        return new CommonResult<>(444, "没有对应记录，查询失败ID:" + id, null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> service = discoveryClient.getServices();
        for (String ele : service) {
            log.info("element : {}", ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        for (ServiceInstance instance : instances) {
            log.info("instance serviceId: {},instance host:{} instance port:{} instance uri:{}", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return discoveryClient;
    }
}
