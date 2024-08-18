package com.nicolasl.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "order_1")
public class Order implements Serializable {
    public static final long serialVersionUID = 1L;
    
    private Integer id;
    private String status;
    private String username;
    private String phone;
    private String address;
    private Integer productId;
    private Integer amount;
    private Integer totalPrice;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
