package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidebarPage {

    private WebDriver driver;
    private By logoutLink = By.id("logout_sidebar_link");

    public SidebarPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLogoutLink(){
        driver.findElement(logoutLink).click();
        return new LoginPage(driver);
    }



}
