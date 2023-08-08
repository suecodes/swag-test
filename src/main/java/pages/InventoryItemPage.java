package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage extends BasePage {

    private By productName = By.className("inventory_details_name");
    private By backToProductsLink = By.id("back-to-products");
    private By addBackPackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpackFromCartButton = By.id("remove-sauce-labs-backpack");
    private By shoppingCartBadge = By.className("shopping_cart_badge");

    public InventoryItemPage(WebDriver driver){
        super(driver);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void clickBackToProductsLink(){
        driver.findElement(backToProductsLink).click();
    }

    public void clickAddBackpackToCart(){
        driver.findElement(addBackPackToCartButton).click();
    }

    public String getAddBackpackToCartText(){
        return driver.findElement(addBackPackToCartButton).getText();
    }

    public void clickRemoveBackpackFromCart(){
        driver.findElement(removeBackpackFromCartButton).click();
    }

    public String getRemoveBackpackFromCartButtonText(){
        return driver.findElement(removeBackpackFromCartButton).getText();
    }

    public Boolean isShoppingCartBadgeDisplayed(){
        try {
            return driver.findElement(shoppingCartBadge).isDisplayed();
        }
        catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public int getCountOfItemsInShoppingCart(){
        return Integer.parseInt(driver.findElement(shoppingCartBadge).getText());
    }

}
