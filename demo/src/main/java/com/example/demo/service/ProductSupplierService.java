package com.example.demo.service;

import com.example.demo.model.entity.ProductSupplier;
import com.example.demo.repository.ProductSupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSupplierService {
	
    private final ProductSupplierRepository productSupplierRepository;

    // Inyección mediante constructor
    public ProductSupplierService(ProductSupplierRepository productSupplierRepository) {
        this.productSupplierRepository = productSupplierRepository;
    }

    public List<ProductSupplier> findAll() {
        return productSupplierRepository.findAll();
    }

    public ProductSupplier save(ProductSupplier productSupplier) {
        return productSupplierRepository.save(productSupplier);
    }
}