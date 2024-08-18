package com.nicolasl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nicolasl.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StaffMapper extends BaseMapper<Staff> {
    
    @Select("SELECT * FROM staff WHERE username = #{username}")
    public Staff selectByUsername(String username);
}
