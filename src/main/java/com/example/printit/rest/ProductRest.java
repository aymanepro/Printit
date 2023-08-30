package com.example.printit.rest;

import com.example.printit.entity.Product;
import com.example.printit.entity.ProductDetail;
import com.example.printit.service.facade.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductRest {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/images/{id}")
    public Product saveImages(@RequestBody List<MultipartFile> images,@PathVariable Long id){
        return this.productService.saveImages(images,id);
    }

    @PostMapping("/details/{id}")
    public Product saveDetails(@RequestBody List<ProductDetail> details, @PathVariable Long id){
        return this.productService.saveDetails(details,id);
    }

    @GetMapping("/")
    public Page<Product> findAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.findAll(pageable);
    }
}
