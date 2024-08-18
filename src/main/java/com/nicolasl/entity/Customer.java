package com.nicolasl.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    public static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
}
