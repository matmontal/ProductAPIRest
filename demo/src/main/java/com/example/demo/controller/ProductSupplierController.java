package com.example.demo.controller;

import com.example.demo.model.entity.ProductSupplier;
import com.example.demo.service.ProductSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product-suppliers")
public class ProductSupplierController {

    @Autowired
    private ProductSupplierService productSupplierService;

    @GetMapping
    public List<ProductSupplier> getAllProductSuppliers() {
        return productSupplierService.findAll();
    }

    @PostMapping
    public ResponseEntity<ProductSupplier> createProductSupplier(@RequestBody ProductSupplier productSupplier) {
        ProductSupplier savedProductSupplier = productSupplierService.save(productSupplier);
        return new ResponseEntity<>(savedProductSupplier, HttpStatus.CREATED);
    }
}