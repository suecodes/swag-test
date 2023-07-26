package login;

import base.BaseTests;
import static org.testng.Assert.*;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class LoginTests extends BaseTests {

    @Test
    @Ignore
    public void testBlankUserNamePasswordLogin(){
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(loginPage.getMessage(), "Epic sadface: Username is required", "Login error message is incorrect");
    }

    @Test
    @Ignore
    public void testMissingUserNameLogin(){
        loginPage.setPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(loginPage.getMessage(), "Epic sadface: Username is required", "Login error message is incorrect");
    }

    @Test
    @Ignore
    public void testMissingPasswordLogin(){
        loginPage.setUsername("standard_user");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(loginPage.getMessage(), "Epic sadface: Password is required", "Login error message is incorrect");
    }

    @Test
    @Ignore
    public void testUnsuccessfulLogin(){
        loginPage.setUsername("fake_user");
        loginPage.setPassword("fake_password");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(loginPage.getMessage(), "Epic sadface: Username and password do not match any user in this service", "Login error message is incorrect");
    }

    @Test
    @Ignore
    public void testSuccessfulLogin(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "Failed to login successfully.");
    }
}
