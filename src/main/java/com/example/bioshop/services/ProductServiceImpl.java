package com.example.bioshop.services;

import com.example.bioshop.exceptions.ProductNotFoundException;
import com.example.bioshop.models.Product;
import com.example.bioshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> products() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public void updateProduct(Long id, Product product) {
        findProduct(id).setName(product.getName());
        findProduct(id).setPrice(product.getPrice());
        findProduct(id).setQuantity(product.getQuantity());
        productRepository.save(findProduct(id));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(findProduct(id));
    }

    @Override
    public Product findProduct(Long id) {
        Product findProduct = productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No product found"));
        return findProduct;
    }
}
