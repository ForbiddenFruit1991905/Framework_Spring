package ru.example.task1.service;

import ru.example.task1.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product productDetails);
    Product createProduct(Product product);
    void deleteProduct(Long id);
}
