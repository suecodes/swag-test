package login;

import base.BaseTests;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class LoginTests extends BaseTests {

    @Test
    public void testBlankUserNamePasswordLogin(){
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(loginPage.getMessage(), "Epic sadface: Username is required", "Error message is incorrect");
    }

    @Test
    public void testMissingUserNameLogin(){
        loginPage.setPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(loginPage.getMessage(), "Epic sadface: Username is required", "Error message is incorrect");
    }

    @Test
    public void testMissingPasswordLogin(){
        loginPage.setUsername("standard_user");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(loginPage.getMessage(), "Epic sadface: Password is required", "Error message is incorrect");
    }

    @Test
    public void testUnsuccessfulLogin(){
        loginPage.setUsername("fakeuser");
        loginPage.setPassword("fakepassword");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(loginPage.getMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message is incorrect");
    }

    @Test
    public void testSuccessfulLogin(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "Page title is incorrect");
    }
}
