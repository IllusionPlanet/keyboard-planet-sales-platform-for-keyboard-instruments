package com.nicolasl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicolasl.entity.Product;
import com.nicolasl.mapper.ProductMapper;
import com.nicolasl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    
    @Override
    public int selectPriceById(int id) {
        return productMapper.selectPriceById(id);
    }
}
