package ru.absens.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.absens.spring.model.Product;
import ru.absens.spring.repositories.InMemoryProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    private InMemoryProductRepository productRepository;

    @Autowired
    public ProductService(InMemoryProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.getProduct(id);
    }

    public void saveProduct(Product product) {
         productRepository.saveProduct(product);
    }

}
