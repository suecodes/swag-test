package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SidebarPage extends BasePage {

    private By logoutLink = By.id("logout_sidebar_link");
    private By closeButton = By.id("react-burger-cross-btn");
    private By burgerMenuButton = By.id("react-burger-menu-btn");

    public SidebarPage(WebDriver driver){
        super(driver);
    }

    // Represents objects common to all pages (except Login page)
    public void clickBurgerMenuButton(){
        WebElement button = waitUntilVisible(burgerMenuButton);
        button.click();
    }

    public void clickLogoutLink()  {
        WebElement link = waitUntilVisible(logoutLink);
        link.click();
    }

    public void clickCloseButton(){
        // TODO: fix issue with overlapping menu
        WebElement button = waitUntilClickable(closeButton);
        button.click();
    }

}
