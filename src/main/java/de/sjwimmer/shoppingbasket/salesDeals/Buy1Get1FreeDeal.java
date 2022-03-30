package de.sjwimmer.shoppingbasket.salesDeals;

import de.sjwimmer.shoppingbasket.api.Product;
import de.sjwimmer.shoppingbasket.api.SalesDeal;

import java.math.BigDecimal;

/**
 * Buy one get one free deal
 */
public class Buy1Get1FreeDeal implements SalesDeal {

    private boolean foundItem = false;
    private boolean isActive = true;

    @Override
    public BigDecimal apply(Product item) {
        BigDecimal price = item.getPrice();

        if(isActive) {
            if(!foundItem) {
                foundItem = true;
            } else {
                isActive = false;
                price = BigDecimal.ZERO;
            }
        }

        return price;
    }
}
