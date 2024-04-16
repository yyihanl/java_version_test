package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(final long id) {
        return productRepository.getOne(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Other CRUD methods (update, delete, etc.)
}