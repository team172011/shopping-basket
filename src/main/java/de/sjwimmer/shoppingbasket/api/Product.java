package de.sjwimmer.shoppingbasket.api;

import java.math.BigDecimal;

public interface Product {

    /**
     *
     * @return the id of this product
     */
    String getId();

    /**
     *
     * @return the price of this product
     */
    BigDecimal getPrice();
}
