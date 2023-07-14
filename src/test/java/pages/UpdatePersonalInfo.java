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

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@value='Edit']")
    public WebElement btnEdit;

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement personalFirstName;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement personalMiddleName;

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement personal_txtEmpLastName;

    @FindBy(id = "personal_optGender_1")
    public WebElement personalGenderMale;

    @FindBy(id = "personal_cmbNation")
    public WebElement personalNationality;

    @FindBy(id = "personal_cmbMarital")
    public WebElement personalMaritalStatusDD;

    public UpdatePersonalInfo() {
        PageFactory.initElements(driver, this);
    }

}
