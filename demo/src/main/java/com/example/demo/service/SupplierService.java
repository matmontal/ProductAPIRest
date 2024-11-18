package com.example.demo.service;

import com.example.demo.model.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
	
    private final SupplierRepository supplierRepository;

    // Inyección mediante constructor
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> findById(Integer id) {
        return supplierRepository.findById(id);
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteById(Integer id) {
        supplierRepository.deleteById(id);
    }
}