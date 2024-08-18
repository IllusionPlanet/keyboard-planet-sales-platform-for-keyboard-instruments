package com.nicolasl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nicolasl.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT price FROM product WHERE id = #{id}")
    public int selectPriceById(int id);
}
