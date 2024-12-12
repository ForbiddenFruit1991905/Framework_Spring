package ru.example.task3.services;

import org.springframework.stereotype.Service;
import ru.example.task3.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
