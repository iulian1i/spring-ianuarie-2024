package com.example.FirstApp.api.dto;

public class ProductDtoModifica {

    String name;
    int priceWithoutTVA;
    int tva;
    int priceWithTVA;

    public String getName() {
        return name;
    }

    public int getPriceWithoutTVA() {
        return priceWithoutTVA;
    }

    public int getTva() {
        return tva;
    }

    public int getPriceWithTVA() {
        return priceWithTVA;
    }
}
