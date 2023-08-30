package com.example.printit.service.imple;

import com.example.printit.dao.ProductCategoryRepository;
import com.example.printit.entity.ProductCategory;
import com.example.printit.service.facade.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImple implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return this.productCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> findAll() {
        return this.productCategoryRepository.findAll();
    }

    @Override
    public int deleteById(Long id) {
        this.productCategoryRepository.deleteById(id);
        return 1;
    }
}
