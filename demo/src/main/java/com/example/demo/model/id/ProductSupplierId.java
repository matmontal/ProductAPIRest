package com.example.demo.model.id;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class ProductSupplierId implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "supplier_id")
    private Long supplierId;
}