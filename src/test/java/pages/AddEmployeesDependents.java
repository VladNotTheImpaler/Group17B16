package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeesDependents extends CommonMethods {

    @FindBy(xpath = "//a[text()='Dependents']")
    public WebElement dependentSection;

    @FindBy(id = "btnAddDependent")
    public WebElement dependentAdd;

    @FindBy(id = "dependent_name")
    public WebElement dependentName;

    @FindBy(id = "dependent_relationshipType")
    public WebElement dependentRelationship;

    @FindBy(id = "dependent_relationship")
    public WebElement dependentRelationshipDesc;

    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[2]")
    public WebElement dependentSpecify;

    @FindBy(id = "dependent_dateOfBirth")
    public WebElement dependentBirth;

    @FindBy(id = "btnSaveDependent")
    public WebElement dependentSave;

    @FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
    public WebElement successSavedDependentMsg;

    @FindBy(id = "btnCancel")
    public WebElement dependentCancel;

    @FindBy(xpath = "//*[@id='frmEmpDependent']/fieldset/ol/li[1]/span")
    public WebElement dependantNameError;

    @FindBy(xpath = "//*[@id='relationshipDesc']/span")
    public WebElement dependantSpecifyError;


    @FindBy(id = "delDependentBtn")
    public WebElement dependentDelete;

    @FindBy(xpath = "//*[@id='dependent_list']/tbody/tr/td[1]/input")
    public WebElement dependentCheckbox;


    public AddEmployeesDependents() {
        PageFactory.initElements(driver, this);
    }


}
