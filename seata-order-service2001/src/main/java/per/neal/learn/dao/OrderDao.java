package per.neal.learn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import per.neal.learn.domain.Order;

@Mapper
public interface OrderDao {
    /**
     * 创建订单
     *
     * @param order Order
     */
    void create(Order order);

    /**
     * 更新状态
     *
     * @param userId 用户ID
     * @param status 状态
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
