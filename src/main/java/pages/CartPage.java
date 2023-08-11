package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private By labelTitle = By.className("title");
    private By shoppingCartBadge = By.className("shopping_cart_badge");
    private By cartItems = By.className("cart_item");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public String getCartPageTitle(){
        return driver.findElement(labelTitle).getText();
    }

    // Shopping cart
    public int getCountOfItemsInShoppingCart(){
        return Integer.parseInt(driver.findElement(shoppingCartBadge).getText());
    }

    public boolean isShoppingCartBadgeDisplayed(){
        try {
            return driver.findElement(shoppingCartBadge).isDisplayed();
        }
        catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public int getProductListCountInCart(){
        return driver.findElements(cartItems).size();
    }

}
