package inventoryitem;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InventoryItemTests extends BaseTests {

    static final int BACKPACK=0;

    @Test
    public void testClickOnProductToViewProductItem(){
        inventoryItemPage = inventoryPage.clickProductItem(BACKPACK);
        assertEquals(inventoryItemPage.getProductName(), "Sauce Labs Backpack", "Product name is incorrect");
    }

    @Test
    public void testViewProductItemAndReturnToProductsPage(){
        inventoryItemPage = inventoryPage.clickProductItem(BACKPACK);
        assertEquals(inventoryItemPage.getProductName(), "Sauce Labs Backpack", "Product name is incorrect");
        inventoryItemPage.clickBackToProductsLink();
        assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "Returned to wrong page, should be Products page");
    }

    @Test
    public void testAddBackpackToCartOnInventoryItemPage(){
        inventoryItemPage = inventoryPage.clickProductItem(BACKPACK);
        inventoryItemPage.clickAddBackpackToCart();
        assertEquals(inventoryItemPage.getRemoveBackpackFromCartButtonText(), "Remove", "Remove Cart for Backpack label incorrect");
        assertTrue(inventoryItemPage.isShoppingCartBadgeDisplayed(), "Product not added to cart");
        assertEquals(inventoryItemPage.getCountOfItemsInShoppingCart(), 1, "Count of items in cart is incorrect");
    }

    @Test
    public void testAddAndRemoveBackpackFromCartOnInventoryItemPage(){
        inventoryItemPage = inventoryPage.clickProductItem(BACKPACK);
        inventoryItemPage.clickAddBackpackToCart();
        inventoryItemPage.clickRemoveBackpackFromCart();
        assertEquals(inventoryItemPage.getAddBackpackToCartText(), "Add to cart", "Add Cart for Backpack label incorrect");
        assertFalse(inventoryItemPage.isShoppingCartBadgeDisplayed(), "Product not removed from cart");
    }
}
