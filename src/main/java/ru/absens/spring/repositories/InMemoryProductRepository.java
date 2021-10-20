package ru.absens.spring.repositories;

import org.springframework.stereotype.Component;
import ru.absens.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Product1", 100),
                new Product(2L, "Product2", 105),
                new Product(3L, "Product3", 110),
                new Product(4L, "Product4", 115),
                new Product(5L, "Product5", 120)
        ));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }
}
