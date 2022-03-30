package de.sjwimmer.shoppingbasket;

import de.sjwimmer.shoppingbasket.api.Basket;
import de.sjwimmer.shoppingbasket.api.Product;
import de.sjwimmer.shoppingbasket.api.SalesDeal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket implements Basket {

    private final List<Product> items = new ArrayList<>();

    @Override
    public void scan(Product item) {
        items.add(item);
    }

    @Override
    public BigDecimal total(Map<String, SalesDeal> salesDeals) {
        return items.stream()
                .map(item -> salesDeals.getOrDefault(item.getId(), SalesDeal.NO_SALES_DEAL).apply(item))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal total() {
        return this.total(new HashMap<>());
    }
}
