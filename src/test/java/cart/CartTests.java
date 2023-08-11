package cart;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTests extends BaseTests {

    static final int BACKPACK = 4;
    static final String BACKPACK_NAME = "Sauce Labs Backpack";
    static final String BACKPACK_PRICE = "$29.99";
    static final String BACKPACK_DESCRIPTION = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

    @Test
    public void testCartPageTitleShowsYourCart(){
        cartPage = inventoryPage.clickShoppingCartLink();
        assertEquals(cartPage.getCartPageTitle(), "Your Cart", "Cart page title is incorrect");
    }

    @Test
    public void testAddProductsToCartAndVerifyCartContainsCorrectCount(){
        inventoryPage.clickAddBikeLightToCart();
        inventoryPage.clickAddBackpackToCart();
        cartPage = inventoryPage.clickShoppingCartLink();
        assertTrue(cartPage.isShoppingCartBadgeDisplayed(), "Product not added to cart");
        assertEquals(cartPage.getCountOfItemsInShoppingCart(), 2, "Count of items in cart is incorrect");
    }

    @Test
    public void testCartPageShowsListOfItemsAddedToCart(){
        inventoryPage.clickAddBackpackToCart();
        inventoryPage.clickAddBikeLightToCart();
        cartPage = inventoryPage.clickShoppingCartLink();
        assertEquals(cartPage.getProductListCountInCart(), 2, "Product List on Carts page shows incorrect amount of products");
    }

    @Test
    public void testCartPageShowsEmptyList(){
        cartPage = inventoryPage.clickShoppingCartLink();
        assertEquals(cartPage.getProductListCountInCart(), 0, "Product List on Carts page should be empty");
    }

    @Test
    public void testAddBackpackToCartAndVerifyProductIsListedOnCartPage(){
        inventoryPage.clickAddBackpackToCart();
        cartPage = inventoryPage.clickShoppingCartLink();
        assertEquals(cartPage.getProductNameById(BACKPACK), BACKPACK_NAME, "Product name by Id does not match expected product name");
        assertEquals(cartPage.getProductPriceById(BACKPACK), BACKPACK_PRICE, "Product price by Id does not match expected product price");
        assertEquals(cartPage.getProductDescriptionById(BACKPACK), BACKPACK_DESCRIPTION, "Product description by Id does not match expected product description");
    }
}
