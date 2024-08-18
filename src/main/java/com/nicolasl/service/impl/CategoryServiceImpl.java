package com.nicolasl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicolasl.entity.Category;
import com.nicolasl.mapper.CategoryMapper;
import com.nicolasl.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    
}
