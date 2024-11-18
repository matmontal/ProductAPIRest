package com.example.demo.repository;

import com.example.demo.model.entity.ProductSupplier;
import com.example.demo.model.id.ProductSupplierId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, ProductSupplierId> {}