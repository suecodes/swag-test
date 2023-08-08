package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class InventoryPage extends BasePage{

    private By labelTitle = By.className("title");
    private By productItem = By.className("inventory_item_name");
    private By inventoryItemPrice = By.className("inventory_item_price");
    private By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpackFromCartButton = By.id("remove-sauce-labs-backpack");
    private By addBikeLightToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeBikeLightFromCartButton = By.id("remove-sauce-labs-bike-light");
    private By addOnesieToCartButton = By.id("add-to-cart-sauce-labs-onesie");
    private By removeOnesieFromCartButton = By.id("remove-sauce-labs-onesie");
    private By shoppingCartBadge = By.className("shopping_cart_badge");
    private By productSortFilter = By.className("product_sort_container");
    private By activeSortOption = By.className("active_option");
    private By shoppingCartLink = By.className("shopping_cart_link");

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

    public List<WebElement> getProductPricesList() {
        return driver.findElements(inventoryItemPrice);
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

    public String getCurrentSortOrderValue(){
        return driver.findElement(activeSortOption).getAttribute("value");
    }

    // Backpack
    public String getPriceOfBackpack(){
        return driver.findElements(inventoryItemPrice).get(0).getText();
    }

    public void clickAddBackpackToCart(){
        driver.findElement(addBackpackToCartButton).click();
    }

    public String getAddBackpackToCartText(){
        return driver.findElement(addBackpackToCartButton).getText();
    }

    public void clickRemoveBackpackFromCart(){
        driver.findElement(removeBackpackFromCartButton).click();
    }

    public String getRemoveBackpackFromCartButtonText(){
        return driver.findElement(removeBackpackFromCartButton).getText();
    }

    // Bike light
    public void clickAddBikeLightToCart(){
        driver.findElement(addBikeLightToCartButton).click();
    }

    public String getAddBikeLightToCartText(){
        return driver.findElement(addBikeLightToCartButton).getText();
    }

    public void clickRemoveBikeLightFromCart(){
        driver.findElement(removeBikeLightFromCartButton).click();
    }

    public String getRemoveBikeLightFromCartButtonText(){
        return driver.findElement(removeBikeLightFromCartButton).getText();
    }

    // Onesie
    public void clickAddOnesieToCart(){
        driver.findElement(addOnesieToCartButton).click();
    }

    public String getAddOnesieToCartText(){
        return driver.findElement(addOnesieToCartButton).getText();
    }

    public void clickRemoveOnesieFromCart(){
        driver.findElement(removeOnesieFromCartButton).click();
    }

    public String getRemoveOnesieFromCartText(){
        return driver.findElement(removeOnesieFromCartButton).getText();
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

    // Products - name, price, description
    public String getProductNameById(int id){
        WebElement element = driver.findElement(By.id("item_" + id + "_title_link"));
        return element.findElement(By.className("inventory_item_name")).getText();
    }

    public String getProductPriceById(int id){
        WebElement idElement = driver.findElement(By.id("item_" + id + "_title_link"));
        WebElement idParentElement = idElement.findElement(By.xpath(".."));
        WebElement superParentElement = idParentElement.findElement(By.xpath(".."));

        return superParentElement.findElement(By.className("inventory_item_price")).getText();
    }

    public String getProductDescriptionById(int id){
        WebElement idElement = driver.findElement(By.id("item_" + id + "_title_link"));
        WebElement idParentElement = idElement.findElement(By.xpath(".."));

        return idParentElement.findElement(By.className("inventory_item_desc")).getText();
    }

    public CartPage clickShoppingCartLink(){
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }

}
