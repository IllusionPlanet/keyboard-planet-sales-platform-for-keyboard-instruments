package com.nicolasl.controller;

import com.nicolasl.common.R;
import com.nicolasl.entity.Customer;
import com.nicolasl.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @Autowired
    CustomerService customerService;
    
    @PostMapping("/login")
    public R<Customer> login(@RequestBody Customer customer, HttpServletRequest request){
//        String password = customer.getPassword();
        Customer customer1 = customerService.selectByUsername(customer.getUsername());
        if(customer1 == null){
            return R.error("用户不存在！");
        }
        if(!customer1.getPassword().equals(customer.getPassword())){
            return R.error("密码不正确！");
        }
        request.getSession().setAttribute("customer",customer1.getId());
        return R.success(customer1);
    }
    
    @PostMapping("/register")
    public R<String> register(@RequestBody Customer customer){
        Customer customer1 = customerService.selectByUsername(customer.getUsername());
        if(customer1 == null){
            customerService.save(customer);
            return R.success("注册成功！");
        } else {
            return R.error("用户名已存在！");
        }
    }
    
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("customer");
        return R.success("退出成功！");
    }
}
