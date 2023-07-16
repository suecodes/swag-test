package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By inputUsername = By.id("user-name");
    private By inputPassword = By.id("password");
    private By loginButton = By.id("login-button");
    private By labelMessage = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
    private By pageHeader = By.className("login_logo");

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

    public String getMessage(){
        return driver.findElement(labelMessage).getText();
    }

    public InventoryPage login(String username, String password){
        driver.findElement(inputUsername).sendKeys(username);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

    public String getPageHeader(){
        return driver.findElement(pageHeader).getText();
    }
}
