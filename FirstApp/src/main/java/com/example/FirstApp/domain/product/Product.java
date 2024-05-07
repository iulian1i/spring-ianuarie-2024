package com.example.FirstApp.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product", schema = "public")
public class Product {

    @Id
    @GeneratedValue
    int id;
    String name;
    int priceWithoutTVA;
    int TVA;
    int priceWithTVA;

}
