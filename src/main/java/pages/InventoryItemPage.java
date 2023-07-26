package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage extends BasePage {

    private By productName = By.className("inventory_details_name");
    private By backToProductsLink = By.id("back-to-products");

    public InventoryItemPage(WebDriver driver){
        super(driver);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void clickBackToProductsLink(){
        driver.findElement(backToProductsLink).click();
    }
}
