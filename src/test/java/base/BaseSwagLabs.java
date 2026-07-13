package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.ScreenshotUtils;

public class BaseSwagLabs {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void initializeBrowser(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {

            /*
             * ChromeOptions is used to configure Chrome
             * before the browser starts.
             */
            ChromeOptions options = new ChromeOptions();

            /*
             * Create preferences for the temporary
             * Chrome profile used by Selenium.
             */
            Map<String, Object> prefs = new HashMap<>();

            /*
             * Disable Chrome password manager service.
             */
            prefs.put("credentials_enable_service", false);

            /*
             * Disable Chrome's built-in password manager.
             */
            prefs.put("profile.password_manager_enabled", false);

            /*
             * Disable the compromised-password /
             * password-leak warning popup.
             */
            prefs.put("profile.password_manager_leak_detection", false);

            /*
             * Pass the preferences to Chrome.
             */
            options.setExperimentalOption("prefs", prefs);

            /*
             * Optional:
             * Disable normal website notification popups.
             */
            options.addArguments("--disable-notifications");

            /*
             * Start Chrome using the configured options.
             */
            driver = new ChromeDriver(options);
        }

        else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }

        else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }

        else {
            throw new IllegalArgumentException(
                    "Invalid Browser: " + browser
            );
        }

        driver.get("https://www.saucedemo.com/");

        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.manage()
              .window()
              .maximize();

        System.out.println("Running test on : " + browser);
    }

    @AfterMethod
    public void browserQuit() throws Exception {
    	
    	
        

        if (driver != null) {
            driver.quit();
        }
    }
}





