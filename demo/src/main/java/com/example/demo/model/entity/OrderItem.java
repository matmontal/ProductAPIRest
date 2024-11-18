package com.example.demo.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item", schema = "public")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer orderItemId;
	
	@ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;
	
	@ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
	
	@Column(name = "quantity")
    private Integer quantity;
	
	@Column(name = "price", precision = 10, scale = 3)
    private BigDecimal price;
}