package com.example.FirstApp.api.dto;

public class ProductDtoAdauga {

    String name;
    int priceWithoutTVA;
    int tva;
    int priceWithTVA;

    public int getPriceWithoutTVA() {
        return priceWithoutTVA;
    }

    public int getTva() {
        return tva;
    }

    public int getPriceWithTVA() {
        return priceWithTVA;
    }

    public String getName() {
        return name;
    }
}
