package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage{

    private By labelTitle = By.className("title");

    public CheckoutStepTwoPage(WebDriver driver){
        super(driver);
    }

    public String getCartPageTitle(){
        return driver.findElement(labelTitle).getText();
    }
}
