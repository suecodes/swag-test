package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage{

    private By labelTitle = By.className("title");
    private By inputFirstName = By.id("first-name");
    private By inputLastName = By.id("last-name");
    private By inputPostalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");

    public CheckoutStepOnePage(WebDriver driver){
        super(driver);
    }

    public String getCartPageTitle(){
        return driver.findElement(labelTitle).getText();
    }

    public void setInputFirstName(String firstName){
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    public void setInputLastName(String lastName){
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    public void setInputPostalCode(String postalCode){
        driver.findElement(inputPostalCode).sendKeys(postalCode);
    }

    public CheckoutStepTwoPage clickContinue(){
        driver.findElement(continueButton).click();
        return new CheckoutStepTwoPage(driver);
    }

    public void clickCancel(){
        driver.findElement(cancelButton).click();
    }
}
