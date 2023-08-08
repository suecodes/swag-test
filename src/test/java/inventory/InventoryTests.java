package inventory;

import base.BaseTests;
import model.Product;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class InventoryTests extends BaseTests {

    public enum SortOrder {
        ASCENDING,
        DESCENDING,
    }

    public enum PriceSortOrder {
        LOWTOHIGH,
        HIGHTOLOW
    }

    @Test(dataProvider = "productData", dataProviderClass = utils.ProductDataProvider.class)
    public void testInventoryPageContainsAllProducts(Product product){
        assertEquals(inventoryPage.getProductNameById(product.getId()), product.getName(), "Product name by Id does not match expected product name");
        assertEquals(inventoryPage.getProductPriceById(product.getId()), product.getPrice(), "Product price by Id does not match expected price");
        assertEquals(inventoryPage.getProductDescriptionById(product.getId()), product.getDescription(), "Product description by Id does not match expected description");
    }

    @Test
    public void testInventoryPageTitleShowsProduct(){
        assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "Product page title is incorrect");
    }

    @Test
    public void testProductsAreListedInDefaultAtoZSortOrder() {
        String sortValue = inventoryPage.getCurrentSortOrder();
        assertEquals("Name (A to Z)", sortValue, "Sort order is not defaulted to 'Name (A to Z)'");

        List<String> productNames = getProductNamesFromList(inventoryPage.getProductNamesList());
        boolean isSorted = isListSorted(productNames, SortOrder.ASCENDING);
        assertTrue(isSorted, "Product names are not in A to Z sort order.");
    }

    @Test
    public void testAllProductsSortedZtoAOrder() {
        inventoryPage.selectSortFilter("za");
        String sortValue = inventoryPage.getCurrentSortOrder();
        assertEquals("Name (Z to A)", sortValue, "Sort Order was not changed to 'Name (Z to A)'");

        List<String> productNames = getProductNamesFromList(inventoryPage.getProductNamesList());
        boolean isSorted = isListSorted(productNames, SortOrder.DESCENDING);
        assertTrue(isSorted, "Product names are not in Z to A sort order.");
    }

    @Test
    public void testAllProductPricesAreSortedLowToHigh(){
        inventoryPage.selectSortFilter("lohi");
        String sortValue = inventoryPage.getCurrentSortOrder();
        assertEquals("Price (low to high)", sortValue,  "Sort Order was not changed to 'Price (low to high)'");

        List<Double> productPrices = getProductPricesFromList(inventoryPage.getProductPricesList());
        boolean isSorted = isPriceListSorted(productPrices, PriceSortOrder.LOWTOHIGH);
        assertTrue(isSorted, "Product prices are not sorted by low to high");
    }

    @Test
    public void testAllProductPricesAreSortedHighToLow(){
        inventoryPage.selectSortFilter("hilo");
        String sortValue = inventoryPage.getCurrentSortOrder();
        assertEquals("Price (high to low)", sortValue,  "Sort Order was not changed to 'Price (high to low)'");

        List<Double> productPrices = getProductPricesFromList(inventoryPage.getProductPricesList());
        boolean isSorted = isPriceListSorted(productPrices, PriceSortOrder.HIGHTOLOW);
        assertTrue(isSorted, "Product prices are not sorted by high to low");
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

    @Test
    public void testAddAndRemoveBackpackFromCart(){
        inventoryPage.clickAddBackpackToCart();
        inventoryPage.clickRemoveBackpackFromCart();
        assertEquals(inventoryPage.getAddBackpackToCartText(), "Add to cart", "Add Cart for Backpack label incorrect");
        assertFalse(inventoryPage.isShoppingCartBadgeDisplayed(), "Product not removed from cart");
    }

    @Test
    public void testAddAndRemoveMultipleProductsFromCart(){
        // add 3 products to cart
        inventoryPage.clickAddBikeLightToCart();
        inventoryPage.clickAddBackpackToCart();
        inventoryPage.clickAddOnesieToCart();
        assertTrue(inventoryPage.isShoppingCartBadgeDisplayed(), "Product not added to cart");
        assertEquals(inventoryPage.getCountOfItemsInShoppingCart(), 3, "Count of items in cart is incorrect");

        // remove 2 products from cart
        inventoryPage.clickRemoveBackpackFromCart();
        inventoryPage.clickRemoveOnesieFromCart();
        assertEquals(inventoryPage.getCountOfItemsInShoppingCart(), 1, "Count of items in cart is incorrect");

        // remove final item from cart
        inventoryPage.clickRemoveBikeLightFromCart();
        assertFalse(inventoryPage.isShoppingCartBadgeDisplayed(), "Product not removed from cart");
    }

    private List<String> getProductNamesFromList(List<WebElement> productNamesList){
        List<String> productNames = new ArrayList<>();

        for (WebElement product : productNamesList) {
            productNames.add(product.getText());
        }
        return productNames;
    }

    private List<Double> getProductPricesFromList(List<WebElement> productPricesList){
        List<Double> productPrices = new ArrayList<>();

        for (WebElement priceElement : productPricesList){
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            productPrices.add(price);
        }
        return productPrices;
    }

    private boolean isListSorted(List<String> list, SortOrder sortOrder){
        List<String> sortedList = new ArrayList<>(list);
        if (sortOrder.equals(SortOrder.ASCENDING)) {
            Collections.sort(sortedList);
        } else if (sortOrder.equals(SortOrder.DESCENDING)) {
            sortedList.sort(Collections.reverseOrder());
        }
        return list.equals(sortedList);
    }

    private boolean isPriceListSorted(List<Double> list, PriceSortOrder sortOrder){
        List<Double> sortedList = new ArrayList<>(list);
        if (sortOrder.equals(PriceSortOrder.LOWTOHIGH)) {
            Collections.sort(sortedList);
        } else if (sortOrder.equals(PriceSortOrder.HIGHTOLOW)) {
            sortedList.sort(Collections.reverseOrder());
        }
        return list.equals(sortedList);
    }
}
