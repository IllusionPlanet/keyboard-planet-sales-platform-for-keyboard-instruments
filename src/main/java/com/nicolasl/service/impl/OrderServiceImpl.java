package com.nicolasl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicolasl.entity.Order;
import com.nicolasl.mapper.OrderMapper;
import com.nicolasl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    
    @Override
    public void updateOrderStatusById(String flag, Integer id) {
        orderMapper.updateOrderStatusById(flag, id);
    }
}
