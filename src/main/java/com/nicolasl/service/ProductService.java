package com.nicolasl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nicolasl.entity.Product;

public interface ProductService extends IService<Product> {
    public int selectPriceById(int id);
}
