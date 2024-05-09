package com.example.FirstApp.api;


import com.example.FirstApp.domain.product.Product;
import com.example.FirstApp.domain.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

//    public ProductController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/test")
    public String productTest() {
        return "<h1>test1234</h1>";
    }

    @GetMapping
    public String productString() {
        return "product String";
    }

}
