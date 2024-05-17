package com.example.FirstApp.api.dto;

public class ProductDtoAdauga {

    String name;
    int priceWithoutTVA;
    int TVA;
    int priceWithTVA;

    public int getPriceWithoutTVA() {
        return priceWithoutTVA;
    }

    public int getTVA() {
        return TVA;
    }

    public int getPriceWithTVA() {
        return priceWithTVA;
    }

    public String getName() {
        return name;
    }
}
