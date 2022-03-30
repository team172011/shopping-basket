package de.sjwimmer.shoppingbasket;

import de.sjwimmer.shoppingbasket.api.Product;
import de.sjwimmer.shoppingbasket.api.Warehouse;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class ShoppingWarehouse implements Warehouse {

    // this may be a repository or api call in a real world
    private final static Map<String, BigDecimal> RAW_DATA_CACHE = new HashMap<>();

    static {
        RAW_DATA_CACHE.put("A0001", BigDecimal.valueOf(12.99));
        RAW_DATA_CACHE.put("A0002", BigDecimal.valueOf(3.99));
    }

    @Override
    public List<Product> getInventory() {
        return RAW_DATA_CACHE.entrySet()
                .stream()
                .map(entrySet -> new ShoppingProduct(entrySet.getKey(), entrySet.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> getItem(String id) {
        if(RAW_DATA_CACHE.containsKey(id)) {
            return Optional.of(new ShoppingProduct(id, RAW_DATA_CACHE.get(id)));
        }
        return Optional.empty();
    }
}
