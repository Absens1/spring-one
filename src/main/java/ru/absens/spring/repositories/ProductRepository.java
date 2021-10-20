package ru.absens.spring.repositories;
import ru.absens.spring.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getProducts();
    Optional<Product> getProduct(Long id);
    void saveProduct(Product product);
}
