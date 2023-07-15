package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class JobEmployeePage extends CommonMethods {
    @FindBy(id="empsearch_id")
    public WebElement idTextField;
    @FindBy(id="searchBtn")
    public WebElement searchButton;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public WebElement employeeID;
    @FindBy(id="sidenav")
    public WebElement jobButton;

    @FindBy(id="btnSave")
    public WebElement editButton;

    @FindBy(id="job_job_title")
    public WebElement jobTitle;

    @FindBy(id="job_emp_status")
    public WebElement jobStatus;

    @FindBy(id="job_eeo_category")
    public WebElement jobCategory;

    @FindBy(id="job_joined_date")
    public WebElement jobDate;

    @FindBy(className="ui-datepicker-month")
    public WebElement jobDateMonth;

    @FindBy(className="ui-datepicker-year")
    public WebElement jobDateYear;

    @FindBy(xpath = "//table/tbody/tr/td")
    public List<WebElement> jobDateDay;

    @FindBy(id="job_sub_unit")
    public WebElement jobUnit;

    @FindBy(id="job_location")
    public WebElement jobLocation;

    @FindBy(id="job_contract_start_date")
    public WebElement jobStartDate;

    @FindBy(id="job_contract_end_date")
    public WebElement jobEndDate;

    @FindBy(id="job_contract_file")
    public WebElement jobFile;

    @FindBy(xpath = "//label[@for='job_contract_update_1']")
    public WebElement radioBtn;

    public JobEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
