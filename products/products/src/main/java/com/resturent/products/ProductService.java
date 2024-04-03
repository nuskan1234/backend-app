package com.resturent.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Products addProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(int id, Products product) {
        if (!productRepository.existsById(id)) {
            return null; // Or throw an exception
        }
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
