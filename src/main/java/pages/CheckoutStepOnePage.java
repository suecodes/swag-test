package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage{

    private By labelTitle = By.className("title");
    private By inputFirstName = By.id("first-name");
    private By inputLastName = By.id("lastname");
    private By inputPostalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");

    public CheckoutStepOnePage(WebDriver driver){
        super(driver);
    }

    public String getCartPageTitle(){
        return driver.findElement(labelTitle).getText();
    }



}
