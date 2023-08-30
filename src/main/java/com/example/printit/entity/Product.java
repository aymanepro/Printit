package com.example.printit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private String libel;

    private String description;

    @ManyToOne
    private ProductCategory productCategory;

    private double rate;

    private double discount;

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    @ElementCollection
    private List<String> keywords;

    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetails;
}
