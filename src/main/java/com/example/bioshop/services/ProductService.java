package com.example.bioshop.services;

import com.example.bioshop.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void saveProduct(Product product);
    List<Product> products();
    void updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Product findProduct(Long id);

    List<Product> findByName(String name);
}
