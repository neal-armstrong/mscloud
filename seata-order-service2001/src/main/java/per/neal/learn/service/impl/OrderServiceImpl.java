package per.neal.learn.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.neal.learn.dao.OrderDao;
import per.neal.learn.domain.Order;
import per.neal.learn.service.AccountService;
import per.neal.learn.service.OrderService;
import per.neal.learn.service.StorageService;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("=========> 开始创建订单=== begin");
        orderDao.create(order);

        log.info("=========> 订单微服务开始调用库存，做扣减===begin");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("=========> 订单微服务开始调用库存，做扣减===end");

        log.info("=========> 订单微服务开始调用账户，做扣减==begin");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("=========> 订单微服务开始调用账户，做扣减===end");

        log.info("=========> 修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("=========> 开始创建订单=== end");
    }
}
