package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeWorkExperiancePage extends CommonMethods {

//    @FindBy(xpath="//*[@id='txtUsername']")
//    public WebElement usernameField;
//
//    @FindBy(id="txtPassword")
//    public WebElement passwordField;
//
//    @FindBy(id="btnLogin")
//    public WebElement loginButton;


    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[@id='sidenav']/li[10]/a")
    public WebElement qualificationtab;

    //@FindBy(xpath = "//input[@id='addWorkExperience']")
    //public WebElement addBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;
    @FindBy(xpath = "//input[@id='addWorkExperience']")
    public WebElement addbtn;
    @FindBy(id = "experience_employer")
    public WebElement company;

    @FindBy(id = "experience_jobtitle")
    public WebElement jobTitle;

    @FindBy(id = "experience_from_date")
    public WebElement fromDate;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement fromMonth;

    @FindBy(xpath = "ui-datepicker-year")
    public WebElement fromYear;

    @FindBy(id = "experience_to_date")
    public WebElement toDate;

    @FindBy(id = "experience_comments")
    public WebElement comments;

    @FindBy(id = "btnWorkExpSave")
    public WebElement workExpSaveBtn;

    @FindBy(id = "workCheckAll")
    public WebElement checkBox;

    @FindBy(xpath = "//*[@id='frmDelWorkExperience']/table/tbody/tr/td[2]/a")
    public WebElement companyTable;

    @FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
    public WebElement successSavedMsgWork;

    @FindBy(xpath = "//*[contains(text(),'Successfully Deleted')]")
    public WebElement successDeleteMsgWork;


    @FindBy(xpath = "//input[@id='delWorkExperience']")
    public WebElement deletework;

    @FindBy(xpath = "//div[@class='message success fadable']")
    public WebElement saveMessage;


    public EmployeeWorkExperiancePage() {

        PageFactory.initElements(driver, this);
    }

}
