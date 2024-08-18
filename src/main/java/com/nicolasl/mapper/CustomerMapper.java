package com.nicolasl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nicolasl.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    
    @Select("SELECT * FROM customer WHERE username = #{username}")
    public Customer selectByUsername(String username);
}
