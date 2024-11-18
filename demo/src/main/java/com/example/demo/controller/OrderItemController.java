package com.example.demo.controller;

import com.example.demo.model.entity.OrderItem;
import com.example.demo.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderitem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) { this.orderItemService = orderItemService; }

    @GetMapping
    public List<OrderItem> getOrderItems() { return orderItemService.findAll(); }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) { return ResponseEntity.ok(orderItemService.save(orderItem)); }
}