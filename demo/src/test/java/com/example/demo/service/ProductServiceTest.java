package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
@ImportAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void testFindAll() {
        Product product1 = new Product();
        product1.setProductId(1);
        product1.setNombre("Product 1");
        product1.setPrecio(new BigDecimal("100"));
        product1.setCantidad((short) 10);

        Product product2 = new Product();
        product2.setProductId(2);
        product2.setNombre("Product 2");
        product2.setPrecio(new BigDecimal("200"));
        product2.setCantidad((short) 5);

        when(productRepository.findAll()).thenReturn(List.of(product1, product2));

        List<Product> products = productService.findAll();

        assertNotNull(products);
        assertEquals(2, products.size());
    }

    @Test
    public void testFindById_ResourceNotFound() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            productService.findById(1).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: 1"));
        });

        assertEquals("Product not found with id: 1", exception.getMessage());
    }

    @Test
    public void testSave() {
        Product product = new Product();
        product.setNombre("Product 1");
        product.setPrecio(new BigDecimal("100"));
        product.setCantidad((short) 10);

        when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.save(product);

        assertNotNull(savedProduct);
        assertEquals("Product 1", savedProduct.getNombre());
    }

    @Test
    public void testDeleteById() {
        productService.deleteById(1);
        verify(productRepository, times(1)).deleteById(1);
    }
}