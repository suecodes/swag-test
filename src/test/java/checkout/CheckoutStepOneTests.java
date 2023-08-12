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

    @Test
    public void testAddBackpackAndCheckout(){
        inventoryPage.clickAddBackpackToCart();
        cartPage = inventoryPage.clickShoppingCartLink();
        checkoutStepOnePage = cartPage.clickCheckoutButton();
        checkoutStepOnePage.setInputFirstName("Fred");
        checkoutStepOnePage.setInputLastName("Flintstone");
        checkoutStepOnePage.setInputPostalCode("90210");
        checkoutStepTwoPage = checkoutStepOnePage.clickContinue();
        assertEquals(checkoutStepOnePage.getCartPageTitle(), "Checkout: Overview", "Checkout page title is incorrect");
    }
}
