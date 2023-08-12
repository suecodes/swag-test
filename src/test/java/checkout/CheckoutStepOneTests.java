package checkout;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CheckoutStepOnePage;

import static org.testng.Assert.assertEquals;

public class CheckoutStepOneTests extends BaseTests {

    @Test
    public void testCheckoutPageTitleShowsYourCart(){
        cartPage = inventoryPage.clickShoppingCartLink();
        checkoutStepOnePage = cartPage.clickCheckoutButton();
        assertEquals(checkoutStepOnePage.getCartPageTitle(), "Checkout: Your Information", "Checkout page title is incorrect");
    }
}
