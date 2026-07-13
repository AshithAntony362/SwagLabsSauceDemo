package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {


    WebDriver driver;


    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }



    /*
     * LOCATOR:
     *
     * Checkout button
     *
     * Inspect:
     *
     * <button id="checkout">
     *
     */

    By checkoutButton =
            By.id("checkout");




    /*
     * LOCATOR:
     *
     * Cart badge showing number of products
     *
     * Example:
     *
     * After adding one product:
     *
     * 1
     *
     *
     * Inspect:
     *
     * <span class="shopping_cart_badge">
     *
     */

    By cartBadge =
            By.className("shopping_cart_badge");





                                                                        // Method:Get cart count
                                                                         // Used later for TestNG Assertion
    
    

    public String getCartCount()
    {
        return driver.findElement(cartBadge).getText();
    }



    // Method:Click Checkout button

    public void clickCheckout()
    {
        driver.findElement(checkoutButton).click();
    }



}
