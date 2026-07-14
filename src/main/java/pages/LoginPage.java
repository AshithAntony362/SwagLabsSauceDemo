package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
WebDriver driver;

//Constructor
//Receives driver from BaseSwagLabs
//and assigns it to this class
	
	public LoginPage(WebDriver driver) {               
		this.driver = driver;              
		
		
	}
	
	/*
	 * LOCATOR 1:
	 *
	 * Username field
	 *
	 * How to locate:
	 *
	 * 1. Open https://www.saucedemo.com/
	 * 2. Right click username field
	 * 3. Select Inspect
	 *
	 *
	 * HTML:
	 *
	 * <input id="user-name">
	 *
	 */
	
	By username = By.id("user-name");                                  
	
	/*
	 * LOCATOR 2:
	 *
	 * Password field
	 *
	 * Inspect:
	 *
	 * <input id="password">
	 *
	 */
	
	By password = By.id("password");                                
	
	/*
	 * LOCATOR 3:
	 *
	 * Login button
	 *
	 * Inspect:
	 *
	 * <input id="login-button">
	 *
	 */
	
	By loginButton = By.xpath("//input[@id='login-button']");             
	
	
	/*
	 * LOCATOR 4:
	 *
	 * Login Error Message
	 */
	
	By loginErrorMessage =
	        By.cssSelector("h3[data-test='error']");
	
	
	/*
	 * Method:
	 *
	 * Enter username into username field
	 *
	 * Value comes from Excel:
	 *
	 * Column 0 = Username
	 *
	 */

	public void enterUsername(String user_name)
	{
	    driver.findElement(username)
	          .sendKeys(user_name);
	}
	
	/*
	 * Method:
	 *
	 * Enter password into password field
	 *
	 * Value comes from Excel:
	 *
	 * Column 1 = Password
	 *
	 */

	public void enterPassword(String pass_word)
	{
	    driver.findElement(password)
	          .sendKeys(pass_word);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	
	
	public void login(String user_name, String pass_word) {
		
		enterUsername(user_name);                                      //as all are non static methods, we can call directly
		enterPassword(pass_word);
		clickLogin();
		
	}
	
	//Method: get Login error message
	
	public String getLoginErrorMessage() {

	    return driver.findElement(loginErrorMessage)
	                 .getText();

	}


}
