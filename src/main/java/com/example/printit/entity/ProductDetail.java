package com.example.printit.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    @ManyToOne
    private Product product;

    private String label;

    @Nullable
    private String image;

    private String description;

    @OneToMany(mappedBy = "productDetail")
    private List<ProductDetailValue> values;

    //Return true if valid
    public boolean isValid() {
        return !(this.description == null || this.description.isEmpty()
                || this.label == null || this.label.isEmpty()
                || this.product == null);
    }
}
