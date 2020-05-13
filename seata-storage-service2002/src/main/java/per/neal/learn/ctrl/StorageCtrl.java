package per.neal.learn.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.neal.learn.entities.CommonResult;
import per.neal.learn.service.StorageService;

import javax.annotation.Resource;

@RestController
public class StorageCtrl {
    @Resource
    private StorageService storageService;

    @GetMapping(value = "/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }
}
