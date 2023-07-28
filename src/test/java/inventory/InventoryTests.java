package inventory;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InventoryItemPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InventoryTests extends BaseTests {

    @Test
    public void testInventoryPageTitleShowsProduct(){
        assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "Product page title is incorrect");
    }

    @Test
    public void testClickOnProductToViewProductItem(){
        inventoryItemPage = inventoryPage.clickProductItem(1);
        assertEquals(inventoryItemPage.getProductName(), "Sauce Labs Backpack", "Product name is incorrect");
    }

    @Test
    public void testGetAllProductNames() {
        // TODO: verify all names are correct based on default (initial page load)
        // 1. First check current sort order = Name (A to Z)
        // 2. Then for each product in list - compare list with default list
        // 3. Possibly store product names in an enum list?

        System.out.println(inventoryPage.getCurrentSortOrder());

        int size = inventoryPage.getCountOfProducts();
        for (int i = 0; i < size; i++) {
            System.out.println(inventoryPage.getProductName(i));
        }
    }

    @Test
    public void testAllProductsSortedAtoZOrder() {
        // TODO:
        // 1. Sort by za
        // 2. Extract the product names and store them in a List of Strings.
        // 3. Create a copy of the list and sort it using the Collections.sort() method to have the correct A-Z order.
        //4. Compare the original list with the sorted list to check if they match.

        inventoryPage.selectSortFilter("az");
        System.out.println(inventoryPage.getCurrentSortOrder());
    }

    @Test
    public void testGetPriceOfBackpack(){
        assertEquals(inventoryPage.getPriceOfBackpack(), "$29.99", "Backpack Price is incorrect");
    }

    @Test
    public void testAddBackpackToCart(){
        inventoryPage.clickAddBackpackToCart();
        assertEquals(inventoryPage.getRemoveBackpackFromCartButtonText(), "Remove", "Remove Cart for Backpack label incorrect");
        assertTrue(inventoryPage.isShoppingCartBadgeDisplayed(), "Product not added to cart");
        assertEquals(inventoryPage.getCountOfItemsInShoppingCart(), 1, "Count of items in cart is incorrect");
    }

    @Test
    public void testAddMultipleProductsToCart(){
        inventoryPage.clickAddBikeLightToCart();
        inventoryPage.clickAddBackpackToCart();
        assertEquals(inventoryPage.getRemoveBackpackFromCartButtonText(), "Remove", "Remove Cart label for Backpack incorrect");
        assertEquals(inventoryPage.getRemoveBikeLightFromCartButtonText(), "Remove", "Remove Cart label for Bike Light incorrect");
        assertTrue(inventoryPage.isShoppingCartBadgeDisplayed(), "Product not added to cart");
        assertEquals(inventoryPage.getCountOfItemsInShoppingCart(), 2, "Count of items in cart is incorrect");
    }

}
