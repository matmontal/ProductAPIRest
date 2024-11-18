package com.example.demo.model.entity;

import com.example.demo.model.id.ProductSupplierId;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "product_supplier", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSupplier {
	
	@EmbeddedId
    private ProductSupplierId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("supplierId")
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private Supplier supplier;
}