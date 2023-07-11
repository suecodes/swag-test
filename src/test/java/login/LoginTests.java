package login;

import base.BaseTests;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "Page title is incorrect");
    }
}
