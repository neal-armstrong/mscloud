package per.neal.learn.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.neal.learn.domain.Order;
import per.neal.learn.entities.CommonResult;
import per.neal.learn.service.OrderService;

import javax.annotation.Resource;


@RestController
public class OrderCtrl {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
