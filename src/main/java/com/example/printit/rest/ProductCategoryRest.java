package com.example.printit.rest;

import com.example.printit.entity.ProductCategory;
import com.example.printit.service.facade.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productCategory")
public class ProductCategoryRest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/")
    public ProductCategory save(@RequestBody ProductCategory productCategory) {
        return productCategoryService.save(productCategory);
    }

    @GetMapping("/")
    public List<ProductCategory> findAll() {
        return productCategoryService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public int deleteById(@PathVariable Long id) {
        return productCategoryService.deleteById(id);
    }
}
