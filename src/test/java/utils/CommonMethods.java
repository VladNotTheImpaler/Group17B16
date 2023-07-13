package utils;


import org.openqa.selenium.WebElement;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonMethods {

public static void radioButton(List<WebElement> radioButton , String value) {
    String actualValue;
    for (WebElement webElement : radioButton) {
        actualValue = webElement.getAttribute("value");
        if (actualValue.equals(value))
            webElement.click();
        break;
    }
}
    public static void isSelected(WebElement element , String radiobutton){
          boolean selected=element.isSelected();
        System.out.println("The radio "+radiobutton+ "is "+selected);
    }
    public static void isDisplayed(WebElement element , String radiobutton){
    boolean displayed=element.isDisplayed();
    System.out.println("The radio "+radiobutton+ "is" +displayed);
}
    public static void isEnabled (WebElement element , String radiobutton) {
        boolean enabled = element.isEnabled();
        System.out.println("The radio " + radiobutton + "is" + enabled);
    }

     public static  String  timeStamp(String pattern){//we can add pattren that we want for date
    //this will return the current date
        Date date= new Date();
        //this will format the date as per our desire pattern
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        //this will return us the formatted date
        return simpleDateFormat.format(date);
    }


}
