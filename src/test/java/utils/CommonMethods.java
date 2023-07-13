package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import steps.PageInitializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public static ChromeOptions optionsChrome;
    public static FirefoxOptions optionsFireFox;


    //method for open browser and getting the url from the Config.properties file
    public static void openBrowserGetURL(String url, String browser) {
        getProperties(Constants.CONFIG_READER_PATH);
        switch (browser) {
            case "chrome" -> {
                optionsChrome = new ChromeOptions();
                // set language
                optionsChrome.addArguments("--lang=en");
                //  create instance
                driver = new ChromeDriver(optionsChrome);
            }
            case "firefox" -> {
                optionsFireFox = new FirefoxOptions();
                // set language
                optionsFireFox.addArguments("--lang=en");
                //  create instance
                driver = new FirefoxDriver(optionsFireFox);
            }
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    //we use this method if we need to connect to the properties to get the data
    // sing another getProperty method
    public static Properties getProperties(String path) {

        FileInputStream fis = null;
        Properties properties = null;

        try {
            fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return properties;
    }

    // we use this method for getting the data from the Config.properties or any other file as well
    public static String getProperty(String key) {

        Properties properties = null;
        try {
            properties = getProperties(Constants.CONFIG_READER_PATH);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);
    }


}
