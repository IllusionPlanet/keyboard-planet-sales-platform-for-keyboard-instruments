package com.nicolasl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nicolasl.entity.Order;
import com.nicolasl.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface OrderService extends IService<Order> {
    public void updateOrderStatusById(String flag, Integer id);
}
