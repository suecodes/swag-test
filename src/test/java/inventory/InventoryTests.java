package inventory;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.InventoryItemPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryTests extends BaseTests {

    public enum SortOrder {
        ASCENDING,
        DESCENDING
    }

    @Test
    public void testInventoryPageTitleShowsProduct(){
        assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "Product page title is incorrect");
    }

    @Test
    public void testClickOnProductToViewProductItem(){
        inventoryItemPage = inventoryPage.clickProductItem(0);
        assertEquals(inventoryItemPage.getProductName(), "Sauce Labs Backpack", "Product name is incorrect");
    }

    @Test
    public void testProductsAreListedInDefaultAtoZSortOrder() {
        String sortValue = inventoryPage.getCurrentSortOrder();
        assertEquals("Name (A to Z)", sortValue, "Default sort order is not A to Z");

        List<String> productNames = getProductNamesFromList(inventoryPage.getProductNamesList());
        boolean isSorted = isListSortedAscending(productNames, SortOrder.ASCENDING);
        assertTrue(isSorted, "Product names are not in A to Z sort order.");
    }

    @Test
    public void testAllProductsSortedZtoAOrder() {
        inventoryPage.selectSortFilter("za");
        String sortValue = inventoryPage.getCurrentSortOrder();
        assertEquals("Name (Z to A)", sortValue, "Default sort order is not Z to A");

        List<String> productNames = getProductNamesFromList(inventoryPage.getProductNamesList());
        boolean isSorted = isListSortedAscending(productNames, SortOrder.DESCENDING);
        assertTrue(isSorted, "Product names are not in Z to A sort order.");
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

    private List<String> getProductNamesFromList(List<WebElement> productNamesList){
        List<String> productNames = new ArrayList<>();

        for (WebElement product : productNamesList) {
            productNames.add(product.getText());
        }
        return productNames;
    }

    private boolean isListSortedAscending(List<String> list, SortOrder sortOrder){
        List<String> sortedList = new ArrayList<>(list);
        if (sortOrder.equals(SortOrder.ASCENDING)) {
            Collections.sort(sortedList);
        } else if (sortOrder.equals(SortOrder.DESCENDING)) {
            sortedList.sort(Collections.reverseOrder());
        }
        return list.equals(sortedList);
    }
}
