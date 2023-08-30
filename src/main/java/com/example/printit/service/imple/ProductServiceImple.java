package com.example.printit.service.imple;

import com.example.printit.dao.ProductRepository;
import com.example.printit.entity.Product;
import com.example.printit.entity.ProductDetail;
import com.example.printit.service.FirebaseService;
import com.example.printit.service.facade.ProductDetailsService;
import com.example.printit.service.facade.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImple implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailsService productDetailsService;

    @Autowired
    private FirebaseService firebaseService;


    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product saveImages(List<MultipartFile> images, Long id) {
        Product product = productRepository.findById(id).get();
        if (product != null){
            product.setImages(new ArrayList<String>());
            for (MultipartFile file : images) {
                try {
                    String url = firebaseService.uploadFile(file);
                    product.getImages().add(url);
                } catch (IOException e) {
                    return null;
                }
            }
            productRepository.save(product);
            return product;
        }
        return null;
    }

    @Override
    public Product saveDetails(List<ProductDetail> details, Long id) {
        Product product = productRepository.findById(id).get();
        if (product != null){
            product.setImages(new ArrayList<String>());
            for (ProductDetail detail : details) {
                detail.setProduct(product);
                productDetailsService.save(detail);
            }
            productRepository.save(product);
            return product;
        }
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
