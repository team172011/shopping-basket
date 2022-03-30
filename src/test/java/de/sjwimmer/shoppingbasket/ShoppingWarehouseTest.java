package de.sjwimmer.shoppingbasket;


import de.sjwimmer.shoppingbasket.api.Product;
import de.sjwimmer.shoppingbasket.api.Warehouse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ShoppingWarehouseTest {

    @Test
    public void testInventoryAccess() {
        final Warehouse warehouse = new ShoppingWarehouse();
        List<Product> inventory = warehouse.getInventory();

        assertEquals(2, inventory.size());
    }

    @Test
    public void testGetItems() {
        final Warehouse warehouse = new ShoppingWarehouse();

        assertFalse(warehouse.getItem("A0001").isEmpty());
        assertFalse(warehouse.getItem("A0002").isEmpty());
        assertTrue(warehouse.getItem("A0003").isEmpty());
    }
}
