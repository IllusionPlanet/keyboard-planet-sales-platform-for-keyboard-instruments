package com.nicolasl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicolasl.entity.Customer;
import com.nicolasl.mapper.CustomerMapper;
import com.nicolasl.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Customer selectByUsername(String username) {
        return customerMapper.selectByUsername(username);
    }
}
