package com.example.printit.dto;

import com.example.printit.entity.ProductDetail;
import jakarta.persistence.ElementCollection;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class ProductVo implements Serializable {
    private String code;

    private String label;

    private String description;

    private String constructor;

    private List<File> images;

    private List<ProductDetail> productDetails;
}
