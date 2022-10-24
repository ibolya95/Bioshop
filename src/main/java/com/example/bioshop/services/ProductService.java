package com.example.bioshop.services;

import com.example.bioshop.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void saveProduct(Product product);
    List<Product> products();
}
