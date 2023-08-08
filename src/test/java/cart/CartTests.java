package cart;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTests extends BaseTests {

    @Test
    public void testCartPageTitleShowsProduct(){
        cartPage = inventoryPage.clickShoppingCartLink();
        assertEquals(cartPage.getCartPageTitle(), "Your Cart", "Cart page title is incorrect");
    }
}
