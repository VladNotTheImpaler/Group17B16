package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

// Changes the focus of the WebDriver to a specified frame,
// enabling interaction with elements inside that frame.
public class CommonMethods {
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
        //this method is going to initialize all the objects available
        // inside this method that is located in PageInitializer class
        initializePageObjects();

    }
    // Method to switch driver focus to a frame using frame ID or name
    public void switchToFrameByNameOrId(String frameNameOrId) {
        driver.switchTo.frame(frameNameOrId);
    }
    // Method to switch driver focus to a frame using frame Index
    public void swithToFrameByIndex(int frameIndex) {
        driver.switchTo.frame(frameIndex);
    }
    // Method to switch driver focus to a frame using frame WebElement
    public void switchToFrameByElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }
    // Method to switch driver focus back to the default content
    public void switchToDefault(){
        driver.switchTo().defaultContent();
    }
}
