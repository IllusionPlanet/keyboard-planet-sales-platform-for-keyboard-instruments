package com.nicolasl.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product implements Serializable {
    public static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer categoryId;
    private BigDecimal price;
    private String image;
    private String description;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    
    private Integer isDeleted;
    
    private String weight;
    private Integer keyNums;
    private String keyboardType;
    private String keyboardForce;
    private String soundSource;
    private String complexToneNums;
    private Integer toneNums;
    private String effects;
    private String functions;
    private String songNums;
    private String recording;
    private String accompaniment;
    private String powerAmplifier;
    private String accessory;
}
