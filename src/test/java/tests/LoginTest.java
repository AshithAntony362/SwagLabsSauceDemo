package tests;

import org.testng.annotations.Test;

import base.BaseSwagLabs;
import pages.LoginPage;
import utils.ExcelUtils;
	
                                                       // Run All
public class LoginTest extends BaseSwagLabs {
LoginPage loginPage;

@Test
                                                    // Run | Debug

public void loginTest() throws Exception {

loginPage = new LoginPage(driver);

  // Read data from Excel
String username = ExcelUtils.getCellData(1, 0);
String password = ExcelUtils.getCellData(1, 1);

  // Use POM
loginPage.login(username, password);

//write result

ExcelUtils.setCellData(7,1, "Login Attempted");
}

}
