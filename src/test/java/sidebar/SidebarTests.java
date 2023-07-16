package sidebar;

import base.BaseTests;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.SidebarPage;

public class SidebarTests extends BaseTests {

    @Test
    public void testLogout(){
        InventoryPage inventoryPage =  loginPage.login("standard_user", "secret_sauce");
        SidebarPage sidebarPage = inventoryPage.clickBurgerMenuButton();
        loginPage = sidebarPage.clickLogoutLink();
        assertEquals(loginPage.getPageHeader(), "Swag Labs", "Expect login page shown");
    }
}
