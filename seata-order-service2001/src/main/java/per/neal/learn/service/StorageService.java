package per.neal.learn.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import per.neal.learn.entities.CommonResult;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣减
     *
     * @param id
     * @param count
     * @return
     */
    @GetMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long id, @RequestParam("count") Integer count);
}
