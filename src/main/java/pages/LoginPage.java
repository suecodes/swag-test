package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By inputUsername = By.id("user-name");
    private By inputPassword = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public InventoryPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

}
