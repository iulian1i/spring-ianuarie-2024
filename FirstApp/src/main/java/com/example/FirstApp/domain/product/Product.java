package com.example.FirstApp.domain.product;

import jakarta.persistence.*;

@Entity
@Table(name = "product", schema = "public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int priceWithoutTVA;
    int TVA;
    int priceWithTVA;

}
