package tests;


import org.testng.annotations.Test;
import org.testng.Assert;

import base.BaseSwagLabs;

import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.MenuPage;

import utils.ExcelUtils;
import utils.ScreenshotUtils;



public class SwagLabsTests extends BaseSwagLabs {



@Test

public void completePurchaseFlow() throws Exception
{


    //SCENARIO 1 : LOGIN


                                                                  // Reading username from Excel
    
    String username =
            ExcelUtils.getCellData(1,0);

                                                              // Reading password from Excel

    String password =
            ExcelUtils.getCellData(1,1);

                                                                // Creating LoginPage object 
                                                               //Driver comes from BaseSwagLabs

    LoginPage loginPage =
            new LoginPage(driver);

                                                             // Login using Excel data

    loginPage.login(username,password);

                                                            //LOGIN ASSERTION
                                                              //After successful login,
                                                                 //URL should contain inventory.html

    Assert.assertTrue(
            driver.getCurrentUrl()
            .contains("inventory.html"),
            "Login Failed"
    );



    // SCENARIO 2 : ADD TO CART


    InventoryPage inventoryPage =
            new InventoryPage(driver);

                                                                 // Add Sauce Labs Backpack

    inventoryPage.clickBackpackAddToCart();

                                                             // Open Cart

    inventoryPage.clickShoppingCart();

                                                                //Verify cart has one item

    CartPage cartPage =
            new CartPage(driver);



    Assert.assertEquals(
            cartPage.getCartCount(),
            "1",
            "Product was not added to cart"
    );
    
    
    // SCENARIO 3 : CHECKOUT
                                                             // Click Checkout button

    cartPage.clickCheckout();

    CheckoutPage checkoutPage =
            new CheckoutPage(driver);

                                                        // Read customer details from Excel

    String firstName =
            ExcelUtils.getCellData(1,2);
    System.out.println("First Name = " + firstName);

    String lastName =
            ExcelUtils.getCellData(1,3);
    System.out.println("Last Name  = " + lastName);

    String zip =
            ExcelUtils.getCellData(1,4);
    System.out.println("ZIP        = " + zip);
    
                                                          // Enter customer information

    checkoutPage.enterCustomerDetails(
            firstName,
            lastName,
            zip
    );

                                                                 // Click Continue
    checkoutPage.clickContinue();

                                                            // Click Finish

    checkoutPage.clickFinish();


                                                               

    String actualMessage = checkoutPage.getOrderConfirmation();
    
    System.out.println("Actual Message = " + actualMessage);

    if (actualMessage.equals("Thank you for your order!")) {

        ScreenshotUtils.takeScreenshot(
                driver, "_SuccessfulCheckout_" + System.currentTimeMillis()
        );

    }
    else {

        ScreenshotUtils.takeScreenshot(
                driver, "_CheckoutFailed_" + System.currentTimeMillis()
        );

    }
    
                                                           // Verify order completion

    Assert.assertEquals(
            actualMessage,
            "Thank you for your order!",
            "Order was not completed"
    );
    
    
    // SCENARIO 4 : LOGOUT
    


    MenuPage menuPage =
            new MenuPage(driver);

                                                          // Open hamburger menu

    menuPage.clickMenu();

                                                        // Click Logout

    menuPage.clickLogout();



    //LOGOUT ASSERTION
     //After logout:
     //User should return to login page
    

    Assert.assertTrue(
            driver.getCurrentUrl()
                  .contains("saucedemo.com"),
            "Logout failed"
    );


}

}