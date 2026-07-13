package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

    /*
     * Method:
     * Capture Screenshot
     */
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {

        // Convert WebDriver into TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Save screenshot inside screenshots folder
        File destination = new File("screenshots/" + fileName + ".png");

        FileHandler.copy(src, destination);

        System.out.println("Screenshot saved successfully.");
    }
}
