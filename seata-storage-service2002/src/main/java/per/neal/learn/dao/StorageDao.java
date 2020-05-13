package per.neal.learn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    /**
     * 扣减库存
     *
     * @param productId 产品ID
     * @param count     数量
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
