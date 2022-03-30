package de.sjwimmer.shoppingbasket.api;

import java.util.List;
import java.util.Optional;

/**
 * Represents the warehouse holding a set of {@link Product products} as inventory
 */
public interface Warehouse {

    /**
     *
     * @return returns the inventory as a list of {@link Product producst}
     */
    List<Product> getInventory();

    /**
     *
     * @param id the id of the requested product
     * @return the {@link Product} for the given id or Optional.empty
     */
    Optional<Product> getItem(String id);

}
