package de.sjwimmer.shoppingbasket;

import de.sjwimmer.shoppingbasket.api.Basket;
import de.sjwimmer.shoppingbasket.api.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketTest {

    @Test
    public void testScan(){
        final List<Product> items = new ShoppingWarehouse().getInventory();
        final Basket basket = new ShoppingBasket();

        basket.scan(items.get(0));

        assertEquals(items.get(0).getPrice(), basket.total());
    }

    @Test
    public void testScanAndTotal(){
        final List<Product> items = new ShoppingWarehouse().getInventory();
        final BigDecimal expectedPrice = items.get(0).getPrice().add(items.get(1).getPrice());
        final Basket basket = new ShoppingBasket();

        basket.scan(items.get(0));
        basket.scan(items.get(1));

        assertEquals(expectedPrice, basket.total());
    }
}
