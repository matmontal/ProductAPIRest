package com.example.demo.service;

import com.example.demo.model.entity.ProductSupplier;
import com.example.demo.repository.ProductSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSupplierService {

    @Autowired
    private ProductSupplierRepository productSupplierRepository;

    public List<ProductSupplier> findAll() {
        return productSupplierRepository.findAll();
    }

    public ProductSupplier save(ProductSupplier productSupplier) {
        return productSupplierRepository.save(productSupplier);
    }
}