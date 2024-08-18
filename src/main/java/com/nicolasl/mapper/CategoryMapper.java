package com.nicolasl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nicolasl.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
