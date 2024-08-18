package com.nicolasl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nicolasl.entity.Staff;

public interface StaffService extends IService<Staff> {
    public Staff selectByUsername(String username);
    
}
