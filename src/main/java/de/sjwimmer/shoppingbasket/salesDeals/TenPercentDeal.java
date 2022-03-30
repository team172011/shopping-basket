package de.sjwimmer.shoppingbasket.salesDeals;

import de.sjwimmer.shoppingbasket.api.Product;
import de.sjwimmer.shoppingbasket.api.SalesDeal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Ten percent deal for a product
 */
public class TenPercentDeal implements SalesDeal {

    @Override
    public BigDecimal apply(Product item) {
        return item.getPrice().multiply(BigDecimal.valueOf(0.9)).setScale(2, RoundingMode.HALF_EVEN);
    }

}
