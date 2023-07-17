package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstNameField;

    @FindBy(id="lastName")
    public WebElement lastNameField;

    @FindBy(id="middleName")
    public WebElement middleNameField;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="employeeId")
    public WebElement employeeIdField;

    @FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
    public WebElement profileEmpId;

    @FindBy(xpath = "//span[@for='firstName']")
    public WebElement requiredFirstNameError;

    @FindBy(xpath = "//span[@for='lastName']")
    public WebElement requiredLastNameError;

    @FindBy(xpath = "//div[@id='profile-pic']/h1")
    public WebElement profileName;


    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
