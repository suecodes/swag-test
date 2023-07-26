package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    private By labelTitle = By.className("title");
    private By productItem = By.className("inventory_item_name");

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public String getInventoryPageTitle(){
        return driver.findElement(labelTitle).getText();
    }

    public InventoryItemPage clickProductItem(){
        driver.findElements(productItem).get(0).click();
        return new InventoryItemPage(driver);
    }
}
