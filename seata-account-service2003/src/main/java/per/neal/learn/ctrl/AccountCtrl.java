package per.neal.learn.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.neal.learn.entities.CommonResult;
import per.neal.learn.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountCtrl {

    @Resource
    private AccountService accountService;

    @GetMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功");
    }
}
