package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage {

    private WebDriver driver;
    private By productName = By.className("inventory_details_name");

    public InventoryItemPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
