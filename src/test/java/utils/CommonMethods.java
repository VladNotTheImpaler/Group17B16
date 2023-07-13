package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {
    public static WebDriver driver;
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }
}

