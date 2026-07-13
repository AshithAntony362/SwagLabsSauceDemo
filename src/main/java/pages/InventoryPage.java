package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {


    WebDriver driver;
                                                                              // Constructor
                                                                                 // Receives the driver from BaseSwagLabs
                                                                                              // and assigns it to this page class

    public InventoryPage(WebDriver driver)
    {
        this.driver = driver;
    }



    /*
     * LOCATOR 1:
     *
     * Sauce Labs Backpack "Add to cart" button
     *
     * How to locate:
     *
     * 1. Open https://www.saucedemo.com/
     * 2. Login using:
     *
     * username:
     * standard_user
     *
     * password:
     * secret_sauce
     *
     * 3. Right click "Add to cart" button under
     *    Sauce Labs Backpack
     *
     * 4. Inspect element
     *
     * Current HTML:
     *
     * <button id="add-to-cart-sauce-labs-backpack">
     *
     *
     */

    By backpackAddToCart =
            By.id("add-to-cart-sauce-labs-backpack");



    /*
     * LOCATOR 2:
     *
     * Shopping cart icon at top right corner
     *
     * Inspect:
     *
     * <a class="shopping_cart_link">
     *
     *
     */

    By shoppingCart =
            By.className("shopping_cart_link");



                                                                                      // Method:Click Add To Cart button

    public void clickBackpackAddToCart()
    {
        driver.findElement(backpackAddToCart).click();
    }



                                                                                                  // Method:Click Cart icon

    public void clickShoppingCart()
    {
        driver.findElement(shoppingCart).click();
    }



}
