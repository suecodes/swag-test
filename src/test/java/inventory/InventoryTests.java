package inventory;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InventoryItemPage;
import pages.InventoryPage;

import static org.testng.Assert.assertEquals;

public class InventoryTests extends BaseTests {

    @Test
    public void testClickOnProductToViewDetails(){
        InventoryPage inventoryPage =  loginPage.login("standard_user", "secret_sauce");
        InventoryItemPage inventoryItemPage = inventoryPage.clickProductItem();
        assertEquals(inventoryItemPage.getProductName(), "Sauce Labs Backpack", "Product name is incorrect");
    }
}
