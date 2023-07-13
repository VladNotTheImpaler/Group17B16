package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

// Changes the focus of the WebDriver to a specified frame,
// enabling interaction with elements inside that frame.
public class CommonMethods {
    public static WebDriver driver;
    public static ChromeOptions optionsChrome;
    public static FirefoxOptions optionsFireFox;


    // Method to switch driver focus to a frame using frame ID or name
    public void switchToFrameByNameOrId(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }
    // Method to switch driver focus to a frame using frame Index
    public void swithToFrameByIndex(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }
    // Method to switch driver focus to a frame using frame WebElement
    public void switchToFrameByElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }
    // Method to switch driver focus back to the default content
    public void switchToDefault(){
        driver.switchTo().defaultContent();
    }

  /*  public void takeScreenshotAndSave(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File screenShot = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShot,
                    new File(Constants.SCREENSHOT_FILEPATH + fileName + " "
                            + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   */
}





