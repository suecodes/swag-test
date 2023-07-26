package inventory;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InventoryItemPage;

import static org.testng.Assert.assertEquals;

public class InventoryTests extends BaseTests {

    @Test
    public void testInventoryPageTitleShowsProduct(){
        assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "Product page title is incorrect");
    }

    @Test
    public void testClickOnProductToViewProductItem(){
        inventoryItemPage = inventoryPage.clickProductItem();
        assertEquals(inventoryItemPage.getProductName(), "Sauce Labs Backpack", "Product name is incorrect");
    }

    @Test
    public void testGetPriceOfBackpack(){
        assertEquals(inventoryPage.getPriceOfBackpack(), "$29.99", "Price is incorrect");
    }

}
