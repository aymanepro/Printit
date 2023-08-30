package com.example.printit.service.facade;

import com.example.printit.entity.ProductDetail;

import java.util.List;

public interface ProductDetailsService {
    public ProductDetail save(ProductDetail productDetail);
    public ProductDetail update(ProductDetail productDetail);
    public List<ProductDetail> findByProductCode(String code);
    int deleteByCode(String code);
}
