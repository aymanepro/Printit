package com.example.printit.service.facade;

import com.example.printit.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory save(ProductCategory productCategory);

    List<ProductCategory> findAll();

    int deleteById(Long id);
}
