package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;
    private By labelTitle = By.className("title");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public String getInventoryPageTitle(){
        return driver.findElement(labelTitle).getText();
    }
}
