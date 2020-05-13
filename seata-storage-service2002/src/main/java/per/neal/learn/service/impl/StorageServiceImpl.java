package per.neal.learn.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.neal.learn.dao.StorageDao;
import per.neal.learn.service.StorageService;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------->storage-service 中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("------------->storage-service 中扣减库存结束");
    }
}
