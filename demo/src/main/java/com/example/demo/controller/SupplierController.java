package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Supplier;
import com.example.demo.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;
    
    // Constante para el mensaje de error
    private static final String SUPPLIER_NOT_FOUND = "Supplier not found with id: ";

    // Inyección mediante constructor
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Integer id) {
        Supplier supplier = supplierService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(SUPPLIER_NOT_FOUND + id));
        return ResponseEntity.ok(supplier);
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.save(supplier);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplierDetails) {
        Supplier supplier = supplierService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(SUPPLIER_NOT_FOUND + id));

        supplier.setName(supplierDetails.getName());
        supplier.setContactInfo(supplierDetails.getContactInfo());

        Supplier updatedSupplier = supplierService.save(supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Integer id) {
    	// Validar si el producto existe y eliminarlo si está presente
        supplierService.findById(id)
                .ifPresentOrElse(
                        product -> supplierService.deleteById(id),
                        () -> { throw new ResourceNotFoundException(SUPPLIER_NOT_FOUND + id); }
                );

        return ResponseEntity.noContent().build();
    }
}