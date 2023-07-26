package sidebar;

import base.BaseTests;
import static org.testng.Assert.*;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class SidebarTests extends BaseTests {

    @Test
    public void openCloseSidebar(){
        sidebarPage.clickBurgerMenuButton();
        sidebarPage.clickCloseButton();
    }
}
