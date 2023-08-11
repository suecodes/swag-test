package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    // Product Listing
    public int getProductListCountInCart(){
        return driver.findElements(cartItems).size();
    }

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

}
