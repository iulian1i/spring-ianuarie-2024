package com.example.FirstApp.api.product.dto;

public class ProductDtoAdauga {

//    @NotEmpty(message = "Trebuie completat numele produsului!")
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
