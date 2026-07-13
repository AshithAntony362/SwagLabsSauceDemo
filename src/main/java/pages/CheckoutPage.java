package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage {


    WebDriver driver;
                                                                                    // Constructor
                                                                                  // Receives driver from BaseSwagLabs
                                                                                   // so this page can perform Selenium actions

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
    }


    /*
     * ==========================================
     * LOCATOR 1 : First Name Field
     * ==========================================
     *
     * How to locate:
     *
     * 1. Login
     * 2. Add product to cart
     * 3. Click Checkout
     * 4. Right click First Name field
     * 5. Inspect element
     *
     *
     * Current HTML:
     *
     * <input id="first-name">
     *
     */

    By firstName =
            By.id("first-name");




    /*
     * ==========================================
     * LOCATOR 2 : Last Name Field
     * ==========================================
     *
     * Inspect:
     *
     * <input id="last-name">
     *
     */

    By lastName =
            By.id("last-name");




    /*
     * ==========================================
     * LOCATOR 3 : ZIP / Postal Code Field
     * ==========================================
     *
     * Inspect:
     *
     * <input id="postal-code">
     *
     */

    By postalCode =
            By.id("postal-code");




    /*
     * ==========================================
     * LOCATOR 4 : Continue Button
     * ==========================================
     *
     * Inspect:
     *
     * <input id="continue">
     *
     */

    By continueButton =
            By.id("continue");




    /*
     * ==========================================
     * LOCATOR 5 : Finish Button
     * ==========================================
     *
     * Inspect:
     *
     * <button id="finish">
     *
     */

    By finishButton =
            By.id("finish");





    /*
     * ==========================================
     * LOCATOR 6 : Order Confirmation Message
     * ==========================================
     *
     * After clicking Finish:
     *
     * Message displayed:
     *
     * "Thank you for your order!"
     *
     *
     * Inspect:
     *
     * <h2 class="complete-header">
     *
     */

    By orderConfirmation =
            By.className("complete-header");





    /* METHOD : Enter Customer Details
     * Values will come from Excel:
     * FirstName
     * LastName
     * Zip
     */

    public void enterCustomerDetails(
            String fname,
            String lname,
            String zip)
    {


        driver.findElement(firstName)
              .sendKeys(fname);



        driver.findElement(lastName)
              .sendKeys(lname);



        driver.findElement(postalCode)
              .sendKeys(zip);


    }



                                                                      // Click Continue button

    public void clickContinue()
    {

        driver.findElement(continueButton)
              .click();

    }


                                                                             //Click Finish button

    public void clickFinish()
    {

        driver.findElement(finishButton)
              .click();

    }


    //Get confirmation message
    //Used for TestNG Assertion

    public String getOrderConfirmation()
    {

        return driver.findElement(orderConfirmation)
                    .getText();

    }

}