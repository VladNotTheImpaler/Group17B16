package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonMethods;

public class PersonalDetailsPage extends CommonMethods {
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[1]/ul/li[6]/a")
    public WebElement jobElement;

    @FindBy(id="btnTerminateEmployement")
    public WebElement terminateButton;

    @FindBy(id="terminateEmployement")
    public WebElement popUp;

    @FindBy(id="terminate_reason")
    public WebElement reasonDD;

    @FindBy(id = "terminate_date")
    public WebElement calendar;

    @FindBy(className = "ui-datepicker-month")
    public WebElement month;

    @FindBy(className = "ui-datepicker-year")
    public WebElement year;
}
