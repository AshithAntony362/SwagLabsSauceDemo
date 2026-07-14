package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSwagLabs;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseSwagLabs {

    LoginPage loginPage;

    @Test
    public void loginTest() throws Exception {

        // Create Login Page Object
        loginPage = new LoginPage(driver);

        // Read Username and Password from Excel
        String username = ExcelUtils.getCellData(1, 0);
        String password = ExcelUtils.getCellData(1, 1);

        System.out.println("Username : " + username);
        System.out.println("Password : " + password);

        // Perform Login using POM
        loginPage.login(username, password);

        // Verify successful login
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login Failed"
        );

        System.out.println("Login Successful");
    }
}