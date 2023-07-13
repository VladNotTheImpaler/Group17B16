package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonMethods {
        public static WebDriver driver;
        static Properties properties;

        public static Properties readProperties(String filePath) {
                try {
                        FileInputStream fileIn = new FileInputStream(filePath);
                        properties = new Properties();
                        properties.load(fileIn);
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return properties;
        }

        public static String getPropertyValue(String key){
                return properties.getProperty(key);
        }
        public static WebDriverWait getWait(){
                WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
                return  wait;
        }
        public static void waitForClickability(WebElement element){
                getWait().until(ExpectedConditions.elementToBeClickable(element));
        }
}
