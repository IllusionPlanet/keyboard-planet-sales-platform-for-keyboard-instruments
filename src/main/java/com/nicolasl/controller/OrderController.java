package com.nicolasl.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicolasl.common.R;
import com.nicolasl.entity.Order;
import com.nicolasl.service.OrderService;
import com.nicolasl.service.ProductService;
import com.sun.deploy.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    
    @PostMapping
    public R<String> insert(@RequestBody Order order){
        order.setStatus("配送中");
        Integer productId = order.getProductId();
        Integer price = productService.selectPriceById(productId) / 100;
        Integer amount = order.getAmount();
        Integer totalPrice = amount * price;
        order.setTotalPrice(totalPrice);

        orderService.save(order);
        return R.success("订单新增成功！");
    }
    
    @GetMapping("/page")
    public R<Page<Order>> selectOrderInPage(int page, int pageSize, Integer id, String beginTime, 
                                            String endTime){
        Page<Order> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Order> lqw = new LambdaQueryWrapper<>();
        if(id != null){
            lqw.eq(Order::getId, id);
        }
        if(beginTime != null && endTime != null){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime beginTime_LDT = LocalDateTime.parse(beginTime, dtf);
            LocalDateTime endTime_LDT = LocalDateTime.parse(endTime, dtf);
            lqw.ge(Order::getCreateTime, beginTime_LDT);
            lqw.le(Order::getCreateTime, endTime_LDT);
        }
        orderService.page(pageInfo, lqw);
        return R.success(pageInfo);
    }

    @GetMapping("/page2")
    public R<Page<Order>> selectOrderInPage(int page, int pageSize, String username){
        Page<Order> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Order> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Order::getUsername, username);
        orderService.page(pageInfo, lqw);
        return R.success(pageInfo);
    }
    
    @PutMapping("/{id}")
    public R<String> updateOrderStatusById(@PathVariable String id){
        Integer id_int = Integer.parseInt(id);
        orderService.updateOrderStatusById("已完成", id_int);
        return R.success("订单状态更改成功！");
    }
    
}
