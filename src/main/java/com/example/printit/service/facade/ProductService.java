package com.example.printit.service.facade;

import com.example.printit.entity.Product;
import com.example.printit.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface ProductService {
    Product save(Product product);

    public Product saveImages(List<MultipartFile> images, Long id);

    Product saveDetails(List<ProductDetail> details, Long id);

    Page<Product> findAll(Pageable pageable);
}
