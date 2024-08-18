package com.nicolasl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nicolasl.entity.Staff;
import com.nicolasl.mapper.StaffMapper;
import com.nicolasl.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService  {
    @Autowired
    private StaffMapper staffMapper;
    
    public Staff selectByUsername(String username){
        return staffMapper.selectByUsername(username);
    }
}
