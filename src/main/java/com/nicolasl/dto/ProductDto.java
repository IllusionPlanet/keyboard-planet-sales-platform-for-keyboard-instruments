package com.nicolasl.dto;

import com.nicolasl.entity.Product;
import lombok.Data;

@Data
public class ProductDto extends Product {
    private String categoryName;
}
