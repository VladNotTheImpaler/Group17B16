package utils;


import org.openqa.selenium.WebElement;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonMethods {

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


}
