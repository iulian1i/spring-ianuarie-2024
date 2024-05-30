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
    Long categoryId;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceWithoutTVA(int priceWithoutTVA) {
        this.priceWithoutTVA = priceWithoutTVA;
    }

    public void setTVA(int TVA) {
        this.TVA = TVA;
    }

    public void setPriceWithTVA(int priceWithTVA) {
        this.priceWithTVA = priceWithTVA;
    }
}
