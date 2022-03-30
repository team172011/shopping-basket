package de.sjwimmer.shoppingbasket;

import de.sjwimmer.shoppingbasket.api.Basket;
import de.sjwimmer.shoppingbasket.api.SalesDeal;
import de.sjwimmer.shoppingbasket.api.Warehouse;
import de.sjwimmer.shoppingbasket.salesDeals.Buy1Get1FreeDeal;
import de.sjwimmer.shoppingbasket.salesDeals.TenPercentDeal;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesDealsTest {

    final Warehouse warehouse = new ShoppingWarehouse();

    @Test
    public void testTenPercentSalesDeal() {
        final SalesDeal tenPercentDeal = new TenPercentDeal();
        final Basket basket = new ShoppingBasket();
        final Map<String, SalesDeal> deals = new HashMap<>();

        deals.put("A0001", tenPercentDeal);

        warehouse.getItem("A0002").ifPresent(basket::scan);
        warehouse.getItem("A0001").ifPresent(basket::scan);
        warehouse.getItem("A0002").ifPresent(basket::scan);

        assertEquals(BigDecimal.valueOf(19.67), basket.total(deals));
    }

    @Test
    public void testBuy1Get1FreeDeal() {
        final SalesDeal buy1Get1FreeDeal = new Buy1Get1FreeDeal();
        final Basket basket = new ShoppingBasket();
        final Map<String, SalesDeal> deals = new HashMap<>();

        deals.put("A0002", buy1Get1FreeDeal);

        warehouse.getItem("A0002").ifPresent(basket::scan);
        warehouse.getItem("A0001").ifPresent(basket::scan);
        warehouse.getItem("A0002").ifPresent(basket::scan);

        assertEquals(BigDecimal.valueOf(16.98), basket.total(deals));
    }

    @Test
    public void testCombinedDeals() {
        final SalesDeal buy1Get1FreeDeal = new Buy1Get1FreeDeal();
        final SalesDeal tenPercentDeal = new TenPercentDeal();
        final Basket basket = new ShoppingBasket();
        final Map<String, SalesDeal> deals = new HashMap<>();
        final BigDecimal expectedPrice = BigDecimal.valueOf(3.99).add(BigDecimal.valueOf(12.99).multiply(BigDecimal.valueOf(0.9))).setScale(2, RoundingMode.HALF_UP);

        deals.put("A0002", buy1Get1FreeDeal);
        deals.put("A0001", tenPercentDeal);

        warehouse.getItem("A0002").ifPresent(basket::scan);
        warehouse.getItem("A0001").ifPresent(basket::scan);
        warehouse.getItem("A0002").ifPresent(basket::scan);

        assertEquals(expectedPrice, basket.total(deals));
    }
}
