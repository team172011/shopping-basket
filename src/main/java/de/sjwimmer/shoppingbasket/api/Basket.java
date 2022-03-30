package de.sjwimmer.shoppingbasket.api;

import java.math.BigDecimal;
import java.util.Map;

/**
 * A Basket represents the users basket that can hold {@link Product products}
 */
public interface Basket {

    /**
     * Adds an item to this basket
     * @param item the item that should be added to this basced
     */
    void scan(Product item);

    /**
     * Calculates the total amount of this basket
     * @return the total amount of this basket
     */
    BigDecimal total();

    /**
     * Calculates the total amount of this basket with active {@link SalesDeal sales deals}
     * @return the total amount of this basket considering given salesDeals
     */
    BigDecimal total(Map<String, SalesDeal> salesDeals);
}
