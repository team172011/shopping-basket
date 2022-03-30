package de.sjwimmer.shoppingbasket.api;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * A sales deal is described by a {@link Function} that can be applied to the
 * corresponding {@link Product}
 */
public interface SalesDeal extends Function<Product, BigDecimal> {

    SalesDeal NO_SALES_DEAL = Product::getPrice;
}
