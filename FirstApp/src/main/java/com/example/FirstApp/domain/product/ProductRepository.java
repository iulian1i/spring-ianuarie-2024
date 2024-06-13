package com.example.FirstApp.domain.product;

import com.example.FirstApp.api.product.dto.ProductCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("""
            SELECT p FROM Product p
            """)
    List<Product> findAllProducts();

    @Query("""
            SELECT p FROM Product p WHERE p.categoryId = :categoryId
            """)
    List<Product> findAllByCategoryId(Long categoryId);

    @Query("""
            SELECT new com.example.FirstApp.api.product.dto.ProductCategoryDto(p.name, c.name)
            FROM Product p JOIN Category c ON p.categoryId = c.id
            WHERE p.id = :productId   
            """)
    ProductCategoryDto findProductAndCategoryDetailsByProductId(int productId);

}
