package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.InventoryItemPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.SidebarPage;

public class BaseTests {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected SidebarPage sidebarPage;
    protected InventoryPage inventoryPage;
    protected InventoryItemPage inventoryItemPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loginSwagLabs(){
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(driver);
        sidebarPage = new SidebarPage(driver);
    }

    @AfterMethod
    public void unloadSwagLabsPage(){
        // return to logout page
        //driver.get("https://www.saucedemo.com/");

        sidebarPage.clickBurgerMenuButton();
        sidebarPage.clickResetAppStateLink();
        sidebarPage.clickLogoutLink();
    }

    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
