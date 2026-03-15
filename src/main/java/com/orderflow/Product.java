package com.orderflow;

import java.util.Objects;

/** Product entity for the order domain. */
public class Product {
    private final String id;
    private final String name;
    private final String currency;
    private final double price;

    public Product(String id, String name, String currency, double price) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.currency = currency != null ? currency : "USD";
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCurrency() { return currency; }
    public double getPrice() { return price; }
}
