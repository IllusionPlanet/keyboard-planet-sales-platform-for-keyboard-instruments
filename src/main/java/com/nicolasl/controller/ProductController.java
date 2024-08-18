package com.nicolasl.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicolasl.common.R;
import com.nicolasl.dto.ProductDto;
import com.nicolasl.entity.Category;
import com.nicolasl.entity.Product;
import com.nicolasl.service.CategoryService;
import com.nicolasl.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    
    @PostMapping
    public R<String> insert(@RequestBody Product product){
        productService.save(product);
        return R.success("新增商品成功！");
    }
    
    @GetMapping("/page")
    public R<Page<ProductDto>> selectByPage(int page, int pageSize, String name){
        Page<Product> pageInfo = new Page<>(page, pageSize);
        Page<ProductDto> productDtoPage = new Page<>();
        
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name != null, Product::getName, name);
        queryWrapper.orderByDesc(Product::getUpdateTime);
        productService.page(pageInfo, queryWrapper);
        
        //对象复制
        BeanUtils.copyProperties(pageInfo, productDtoPage, "records");
        List<Product> records = pageInfo.getRecords();
        List<ProductDto> list = records.stream().map((item)->{
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(item, productDto);
            //拿取Id
            Integer categoryId =  item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            String categoryName = category.getName();
            productDto.setCategoryName(categoryName);
            return productDto;
        }).collect(Collectors.toList());
        productDtoPage.setRecords(list);
        return R.success(productDtoPage);
    }


    @GetMapping("/{id}")
    public R<Product> select(@PathVariable Integer id){
        Product product = productService.getById(id);
        return R.success(product);
    }
    
    @PutMapping
    public R<String> update(@RequestBody Product product){
        productService.updateById(product);
        return R.success("信息修改成功！");
    }
    
    @GetMapping("/display")
    public R<Page<Product>> selectInPageByNameAndCategoryId(int page, int pageSize, String name, String categoryId_str){
        Page<Product> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Product> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Product::getName, name);
        Integer categoryId = Integer.parseInt(categoryId_str);
        lqw.eq(Product::getCategoryId, categoryId);
        productService.page(pageInfo, lqw);
        return R.success(pageInfo);
    }
    
    @DeleteMapping
    public R<String> deleteById(Integer id){
        productService.removeById(id);
        return R.success("商品删除成功！");
    }
}
