package ru.absens.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.absens.spring.model.Product;
import ru.absens.spring.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8189/app/products/all
    @GetMapping("/all")
    public String showAllProductsInfo(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products_info";
    }
    // http://localhost:8189/app/products/{id}
    @GetMapping("/{id}")
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "product_info";
    }

    // http://localhost:8189/app/products/create
    @GetMapping("/create")
    public String showCreator() {
        return "create_product_form";
    }

    // http://localhost:8189/app/products/create?id=10&name=Nicolas&score=95
    @PostMapping("/create")
    public String createNewProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int cost) {
        Product product = new Product(id, title, cost);
        productService.saveProduct(product);
        return "redirect:/products/all";
    }
}
