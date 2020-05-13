package per.neal.learn.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.neal.learn.dao.AccountDao;
import per.neal.learn.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service 中扣减客户余额开始");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);
        log.info("------->account-service 中扣减客户余额结束");
    }
}
