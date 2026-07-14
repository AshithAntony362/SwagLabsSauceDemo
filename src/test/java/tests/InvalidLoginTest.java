package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSwagLabs;
import pages.LoginPage;

public class InvalidLoginTest extends BaseSwagLabs {

    LoginPage loginPage;

    @Test

    public void invalidLoginTest() {

        loginPage = new LoginPage(driver);

        // ==========================================
        // Test Case 1
        // Username : standard_use
        // Password : secre_sauce
        // ==========================================

        loginPage.login("standard_use", "secre_sauce");

        String actualError = loginPage.getLoginErrorMessage();

        System.out.println("Test Case 1");
        System.out.println("Username : standard_use");
        System.out.println("Password : secre_sauce");
        System.out.println("Error : " + actualError);

        Assert.assertTrue(
                actualError.contains("Username and password do not match"),
                "Invalid Login Test Case 1 Failed"
        );

        // Refresh page before next test
        driver.navigate().refresh();

        // ==========================================
        // Test Case 2
        // Username : standard_user
        // Password : secre_sauc
        // ==========================================

        loginPage.login("standard_user", "secre_sauc");

        actualError = loginPage.getLoginErrorMessage();

        System.out.println("Test Case 2");
        System.out.println("Username : standard_user");
        System.out.println("Password : secre_sauc");
        System.out.println("Error : " + actualError);

        Assert.assertTrue(
                actualError.contains("Username and password do not match"),
                "Invalid Login Test Case 2 Failed"
        );

        System.out.println("Invalid Login Test Passed");

    }

}