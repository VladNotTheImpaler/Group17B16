package utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

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

    public static void waitForAppear(WebElement locator, int sec) {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitForDisappear(WebElement locator, int sec) {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.invisibilityOf(locator));
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
        TakesScreenshot ts = (TakesScreenshot) driver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        element.sendKeys(text);
    }

    //close browser method
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


    public static void selectFromDropdown(WebElement dd, String selectBy, String value) {
        Select sel = new Select(dd);

        if (selectBy.equalsIgnoreCase("VisibleText")) {
            sel.selectByVisibleText(value);
        } else if (selectBy.equalsIgnoreCase("Value")) {
            sel.selectByValue(value);
        } else if (selectBy.equalsIgnoreCase("Index")) {
            int index = Integer.parseInt(value);
            sel.selectByIndex(index);
        } else {
            throw new IllegalArgumentException("Please use VisibleText,Value,Index");
        }
    }

    //method for multiply drop-down selection and select all options at once
    public static void multiplyDropDown(WebElement variable, List<String> attributeValuesToSelect, boolean selectAll) {
        var obj = new Select(variable);
        var options = obj.getOptions();
        for (var option : options) {
            var optionText = option.getText();
            if (attributeValuesToSelect.contains(optionText) || selectAll) {
                option.click();
                //break;
            }
        }
    }

    //please don`t delete I need this method for my step UpdatePersonalInfo class
    //don`t delete
    public static List<String> getDisplayedFields() {
        List<String> displayedFields = new ArrayList<>();
        displayedFields.add(updatePersonalInfo.personalFirstName.getAttribute("title"));
        displayedFields.add(updatePersonalInfo.personalMiddleName.getAttribute("title"));
        displayedFields.add(updatePersonalInfo.personalLastName.getAttribute("title"));
        displayedFields.add(updatePersonalInfo.personalGenderMale.getText());
        displayedFields.add(updatePersonalInfo.personalGenderFemale.getText());
        displayedFields.add(updatePersonalInfo.personalNationality.getAttribute("id"));
        displayedFields.add(updatePersonalInfo.personalMaritalStatusDD.getAttribute("id"));

        return displayedFields;
    }

    //please dont delete I need this method for my step AddDependents class
    //dont delete
    public static List<String> getDisplayedDependentsFields () {
        List<String> displayedFields = new ArrayList<>();
        displayedFields.add(addEmployeesDependents.dependentName.getAttribute("id"));
        displayedFields.add(addEmployeesDependents.dependentRelationship.getAttribute("id"));
        displayedFields.add(addEmployeesDependents.dependentBirth.getAttribute("id"));

        return displayedFields;
    }

    // read ExcelFile
    // was used rebuild method for UpdatePersonalInfo step class - don`t delete
    //My code would not work with ExcelReader class so I just copy pasted it here
    public static List<Map<String, String>> readExcelData(String sheetName, String path) {

        FileInputStream fileInputStream = null;
        List<Map<String, String>> excelData = new ArrayList<>();

        try {
            fileInputStream = new FileInputStream(path);
            // that special call which knows how to read the data from Excel files
            //.xls - hssf workbook and .xlsx - xssf workbook
            var xssfWorkbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = xssfWorkbook.getSheet(sheetName);

            var headerRow = sheet.getRow(0);
            for (int rows = 1; rows < sheet.getPhysicalNumberOfRows(); rows++) {
                Row row = sheet.getRow(rows);

                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int col = 0; col < row.getPhysicalNumberOfCells(); col++) {
                    String key = headerRow.getCell(col).toString();
                    String value = row.getCell(col).toString();
                    rowMap.put(key, value);
                }
                excelData.add(rowMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return excelData;
    }


    //This method clicks on a web element after waiting for it to be clickable.
    //It handles any exceptions by printing and error message

    public static void click(WebElement element, int sec){

        try{
            waitForClick(element,sec);
            element.click();
        }catch (Exception e){
            System.out.println("Unable to click element: "+element);
        }
    }
}

