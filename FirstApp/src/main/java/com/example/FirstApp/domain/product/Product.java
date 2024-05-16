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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriceWithoutTVA() {
        return priceWithoutTVA;
    }

    public int getTVA() {
        return TVA;
    }

    public int getPriceWithTVA() {
        return priceWithTVA;
    }
}
