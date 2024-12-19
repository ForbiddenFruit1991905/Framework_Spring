package ru.example.task1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.task1.model.Product;
import ru.example.task1.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setQuantityInStock(productDetails.getQuantityInStock());
            return productRepository.save(product);
        } else {
            throw  new IllegalArgumentException("Product is not found");
        }
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
