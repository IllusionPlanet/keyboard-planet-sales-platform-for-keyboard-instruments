package com.nicolasl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nicolasl.entity.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Update("UPDATE order_1 SET status = #{flag} WHERE id = #{id}")
    public void updateOrderStatusById(@Param("flag") String flag, @Param("id") Integer id);
}
