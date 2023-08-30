package com.example.printit.service.imple;

import com.example.printit.dao.ProductDetailRepository;
import com.example.printit.dao.ProductRepository;
import com.example.printit.entity.ProductDetail;
import com.example.printit.service.facade.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImple implements ProductDetailsService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetail save(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }


    @Override
    public ProductDetail update(ProductDetail productDetail) {
        return null;
    }

    @Override
    public List<ProductDetail> findByProductCode(String code) {
        return productDetailRepository.findByProductCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return productDetailRepository.deleteByCode(code);
    }
}
