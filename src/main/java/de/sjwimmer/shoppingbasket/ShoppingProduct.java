package de.sjwimmer.shoppingbasket;

import de.sjwimmer.shoppingbasket.api.Product;

import java.math.BigDecimal;

public class ShoppingProduct implements Product {

    private final String id;
    private final BigDecimal price;

    public ShoppingProduct(String id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }
}
