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
    public void testAddBackpackAndCheckoutWithYourInformationFilled(){
        inventoryPage.clickAddBackpackToCart();
        cartPage = inventoryPage.clickShoppingCartLink();
        checkoutStepOnePage = cartPage.clickCheckoutButton();
        checkoutStepOnePage.setInputFirstName("Fred");
        checkoutStepOnePage.setInputLastName("Flintstone");
        checkoutStepOnePage.setInputPostalCode("90210");
        checkoutStepTwoPage = checkoutStepOnePage.clickContinue();
        assertEquals(checkoutStepOnePage.getCartPageTitle(), "Checkout: Overview", "Checkout page title is incorrect");
    }

    // Below tests checks error message is shown
    @Test
    public void testAddBackpackAndCheckoutWithNoInformation(){
        inventoryPage.clickAddBackpackToCart();
        cartPage = inventoryPage.clickShoppingCartLink();
        checkoutStepOnePage = cartPage.clickCheckoutButton();
        checkoutStepTwoPage = checkoutStepOnePage.clickContinue();
        assertEquals(checkoutStepOnePage.getErrorMessageText(), "Error: First Name is required", "Error message text is incorrect");
    }

    @Test
    public void testAddBackpackAndCheckoutWithFirstNameOnly(){
        inventoryPage.clickAddBackpackToCart();
        cartPage = inventoryPage.clickShoppingCartLink();
        checkoutStepOnePage = cartPage.clickCheckoutButton();
        checkoutStepOnePage.setInputFirstName("Fred");
        checkoutStepTwoPage = checkoutStepOnePage.clickContinue();
        assertEquals(checkoutStepOnePage.getErrorMessageText(), "Error: Last Name is required", "Error message text is incorrect");
    }

    @Test
    public void testAddBackpackAndCheckoutWithFirstNameAndLastNameOnly(){
        inventoryPage.clickAddBackpackToCart();
        cartPage = inventoryPage.clickShoppingCartLink();
        checkoutStepOnePage = cartPage.clickCheckoutButton();
        checkoutStepOnePage.setInputFirstName("Fred");
        checkoutStepOnePage.setInputLastName("Flintstone");
        checkoutStepTwoPage = checkoutStepOnePage.clickContinue();
        assertEquals(checkoutStepOnePage.getErrorMessageText(), "Error: Postal Code is required", "Error message text is incorrect");
    }

}
