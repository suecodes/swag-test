package base;

import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;
import utils.CSVDataReader;

import java.io.IOException;
import java.util.List;

public class BaseTests {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected SidebarPage sidebarPage;
    protected InventoryPage inventoryPage;
    protected InventoryItemPage inventoryItemPage;
    protected CartPage cartPage;
    protected CheckoutStepOnePage checkoutStepOnePage;
    protected CheckoutStepTwoPage checkoutStepTwoPage;
    private List<Product> productsList;

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
        // return to log out page
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

    public void productsData() throws IOException {
        productsList = CSVDataReader.readProductsFromCSV();

        for (Product product : productsList){
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Description: " + product.getDescription());
        }
    }
}
