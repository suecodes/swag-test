package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    private By labelTitle = By.className("title");
    private By productItem = By.className("inventory_item_name");
    private By inventoryItemPrice = By.className("inventory_item_price");
    private By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpackFromCartButton = By.id("remove-sauce-labs-backpack");
    private By addBikeLightToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By shoppingCartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public String getInventoryPageTitle(){
        return driver.findElement(labelTitle).getText();
    }

    public InventoryItemPage clickProductItem(){
        driver.findElements(productItem).get(0).click();
        return new InventoryItemPage(driver);
    }

    public String getPriceOfBackpack(){
        return driver.findElements(inventoryItemPrice).get(0).getText();
    }

    public String getRemoveBackpackToCartButtonText(){
        return driver.findElement(removeBackpackFromCartButton).getText();
    }

    public void clickAddBackpackToCart(){
        driver.findElement(addBackpackToCartButton).click();
    }

    public int getCountOfItemsInShoppingCart(){
        return Integer.parseInt(driver.findElement(shoppingCartBadge).getText());
    }

    public void clickAddBikeLightToCart(){

    }

    public boolean isShoppingCartBadgeDisplayed(){
        return driver.findElement(shoppingCartBadge).isDisplayed();
    }
}
