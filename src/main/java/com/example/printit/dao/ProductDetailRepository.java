package com.example.printit.dao;

import com.example.printit.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    List<ProductDetail> findByProductCodeAndCode(String productCode, String code);
    List<ProductDetail> findByProductCode(String code);
    int deleteByCode(String Code);
}
