package com.nicolasl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nicolasl.entity.Customer;

public interface CustomerService extends IService<Customer> {
    public Customer selectByUsername(String username);
}
