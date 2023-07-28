package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends BasePage{

    private By labelTitle = By.className("title");
    private By productItem = By.className("inventory_item_name");
    private By inventoryItemPrice = By.className("inventory_item_price");
    private By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpackFromCartButton = By.id("remove-sauce-labs-backpack");
    private By addBikeLightToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeBikeLightFromCartButton = By.id("remove-sauce-labs-bike-light");
    private By shoppingCartBadge = By.className("shopping_cart_badge");
    private By productSortFilter = By.className("product_sort_container");
    private By activeSortOption = By.className("active_option");

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public String getInventoryPageTitle(){
        return driver.findElement(labelTitle).getText();
    }

    public InventoryItemPage clickProductItem(int index){
        driver.findElements(productItem).get(index).click();
        return new InventoryItemPage(driver);
    }

    public String getProductName(int index) {
        return driver.findElements(productItem).get(index).getText();
    }

    public List<WebElement> getProductNamesList() {
        return driver.findElements(productItem);
    }

    public void selectSortFilter(String value){
        WebElement sort = driver.findElement(productSortFilter);
        Select select = new Select(sort);
        select.selectByValue(value);
    }

    public int getCountOfProducts(){
        return driver.findElements(productItem).size();
    }

    public String getCurrentSortOrder(){
        return driver.findElement(activeSortOption).getText();
    }

    public String getPriceOfBackpack(){
        return driver.findElements(inventoryItemPrice).get(0).getText();
    }

    public void clickAddBackpackToCart(){
        driver.findElement(addBackpackToCartButton).click();
    }

    public String getRemoveBackpackFromCartButtonText(){
        return driver.findElement(removeBackpackFromCartButton).getText();
    }

    public void clickAddBikeLightToCart(){
        driver.findElement(addBikeLightToCartButton).click();
    }

    public String getRemoveBikeLightFromCartButtonText(){
        return driver.findElement(removeBikeLightFromCartButton).getText();
    }

    public int getCountOfItemsInShoppingCart(){
        return Integer.parseInt(driver.findElement(shoppingCartBadge).getText());
    }

    public boolean isShoppingCartBadgeDisplayed(){
        return driver.findElement(shoppingCartBadge).isDisplayed();
    }
}
