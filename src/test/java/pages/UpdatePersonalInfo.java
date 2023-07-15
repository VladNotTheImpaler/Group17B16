package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class UpdatePersonalInfo extends CommonMethods {

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(id = "empsearch_id")
    public WebElement idTextField;

    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[2]")
    public WebElement idTableCell;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'Personal Details')]")
    public WebElement titlePersonalDetails;

    @FindBy(xpath = "//*[@value='Edit']")
    public WebElement btnEdit;

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement personalFirstName;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement personalMiddleName;

    @FindBy(id = "personal_txtEmpLastName")
    public WebElement personalLastName;

    @FindBy(xpath = "//*[contains(text(),'Male')]")
    public WebElement personalGenderMale;

    @FindBy(id = "personal_optGender_1")
    public WebElement personalGenderIDMale;

    //personal_optGender_1
    @FindBy(xpath = "//*[contains(text(),'Female')]")
    public WebElement personalGenderFemale;

    @FindBy(id = "personal_optGender_2")
    public WebElement personalGenderIDFemale;

    @FindBy(id = "personal_cmbNation")
    public WebElement personalNationality;

    @FindBy(id = "personal_cmbMarital")
    public WebElement personalMaritalStatusDD;

    public UpdatePersonalInfo() {
        PageFactory.initElements(driver, this);
    }

}
