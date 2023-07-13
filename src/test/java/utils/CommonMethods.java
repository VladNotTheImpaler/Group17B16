package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        //this method is going to initialize all the objects available
        // inside this method that is located in PageInitializer class
        initializePageObjects();
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


    // we use this method for getting the data from the Config.properties
    // or any other file as well
    public static String getProperty(String key) {

        Properties properties = null;
        try {
            properties = getProperties(Constants.CONFIG_READER_PATH);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);
    }


    //single checkbox method and boolean implicitWait
    //Example: WebElement variable = driver.findElement...
    public static void singleCheckBox(WebElement variable, boolean enableImplicitWait) {
        if (enableImplicitWait) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        if (!variable.isSelected()) {
            variable.click();
        }
    }

    //multiply checkbox selection and option to select all checkboxes
    //Example: List<WebElement> variable = driver.findElements...
    //Example: List<String> attributeValuesToSelect = Arrays.asList("Option-2", "Option-4");
    public static void checkBoxMultiple(List<WebElement> variable, List<String> attributeValuesToSelect, boolean selectAllOrNot) {
        for (var select : variable) {
            var codeValue = select.getAttribute("value");
            if (select.isSelected()) {
                select.clear();
            } else if (selectAllOrNot || attributeValuesToSelect.contains(codeValue)) {
                select.click();
                //break;
            }
        }
    }

    //method to select radio button from multiply selection
    public static void radioButtonMultiply(List<WebElement> radioButton, String value) {
        for (WebElement webElement : radioButton) {
            String actualValue = webElement.getAttribute("value");
            if (actualValue.equals(value))
                webElement.click();
            break;
        }
    }

    //method for selecting the single radio button
    public static void radioButton(WebElement variable) {
        variable.click();
    }


    //void method for checking isSelected radioButton or not
    public static void isSelected(WebElement element, String radiobutton) {
        boolean selected = element.isSelected();
        System.out.println("The radio " + radiobutton + "is " + selected);
    }

    //void method for checking isDisplayed radioButton or not
    public static void isDisplayed(WebElement element, String radiobutton) {
        boolean displayed = element.isDisplayed();
        System.out.println("The radio " + radiobutton + "is" + displayed);
    }

    //void method for checking isEnabled radioButton or not
    public static void isEnabled(WebElement element, String radiobutton) {
        boolean enabled = element.isEnabled();
        System.out.println("The radio " + radiobutton + "is" + enabled);
    }


    //The purpose of this method is to provide a convenient way to
    // get the current date and time in a specific format
    public static String timeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        return simpleDateFormat.format(date);
    }


    //method for the implicitWait set-up
    public static void implicitWait(int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    //method for the explicitWait set-up
    public static void waitForClick(WebElement element, int sec) {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Method to switch driver focus to a frame using frame ID or name
    public void switchToFrameByNameOrId(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }

    // Method to switch driver focus to a frame using frame Index
    public void switchToFrameByIndex(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    // Method to switch driver focus to a frame using frame WebElement
    public void switchToFrameByElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    // Method to switch driver focus back to the default content
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }


    // method for taking the screenshots specifically for the Cucumber +
    // attach it to the report using the array of bytes concepts
    public static byte[] takeScreenshot(String name) {
        var ts = (TakesScreenshot) driver;
        var picBytes = ts.getScreenshotAs(OutputType.BYTES);
        var file = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(Constants.SCREENSHOT_FOLDER_PATH + name + " " +
                    getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;
    }

    //this method help us to get the current time
    public static String getTimeStamp(String pattern) {
        //this function return the date
        var date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    //method for sending the text to the filed
    public static void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }

    //close browser method
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}

