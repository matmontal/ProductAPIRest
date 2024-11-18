package com.example.demo.controller;

import com.example.demo.model.entity.Inventory;
import com.example.demo.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {this.inventoryService = inventoryService;}

    @GetMapping
    public List<Inventory> getInventories() { return inventoryService.findAll(); }
}