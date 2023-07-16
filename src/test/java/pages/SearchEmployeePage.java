package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class SearchEmployeePage extends CommonMethods {
    @FindBy(id="empsearch_id")
    public WebElement idTextField;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement nameTextField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public WebElement listedEmployeeID;

    public SearchEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
