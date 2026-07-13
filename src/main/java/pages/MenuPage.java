package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MenuPage {


    WebDriver driver;

                                                                                   // Constructor
                                                                                     // Receives driver from BaseSwagLabs

    public MenuPage(WebDriver driver)
    {
        this.driver = driver;
    }



    /*
     * ==========================================
     * LOCATOR 1 : Hamburger Menu Button
     * ==========================================
     *
     * Location:
     *
     * Top left corner after login
     *
     * Inspect element:
     *
     * <button id="react-burger-menu-btn">
     *
     */

    By menuButton =
            By.id("react-burger-menu-btn");




    /*
     * ==========================================
     * LOCATOR 2 : Logout Link
     * ==========================================
     *
     * After clicking hamburger menu:
     *
     * Logout option appears
     *
     *
     * Inspect:
     *
     * <a id="logout_sidebar_link">
     *
     */

    By logoutLink =
            By.id("logout_sidebar_link");




                                                                     // METHOD : Open Menu
   

    public void clickMenu()
    {

        driver.findElement(menuButton)
              .click();

    }



                                                                           //METHOD : Logout
 

    public void clickLogout() throws InterruptedException
    {
    	
    	Thread.sleep(1000);
        driver.findElement(logoutLink)
              .click();

    }


}
