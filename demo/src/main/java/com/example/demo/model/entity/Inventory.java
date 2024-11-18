package com.example.demo.model.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory", schema = "public")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;
	
	@ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
	
	@Column(name = "quantity")
    private Integer quantity;
	
	@Column(name = "last_updated")
    private Date lastUpdated;
}