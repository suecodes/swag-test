package cart;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTests extends BaseTests {

    @Test
    public void testCartPageTitleShowsYourCart(){
        cartPage = inventoryPage.clickShoppingCartLink();
        assertEquals(cartPage.getCartPageTitle(), "Your Cart", "Cart page title is incorrect");
    }

    @Test
    public void testAddProductsToCartAndViewCartContainsCorrectCount(){
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
    public void testCartPageShowsEmptyListOfItems(){
        cartPage = inventoryPage.clickShoppingCartLink();
        assertEquals(cartPage.getProductListCountInCart(), 0, "Product List on Carts page should be empty");
    }
}
