package com.nicolasl.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String name;

    private String password;

    private String phone;
    
    private Integer status;
}
