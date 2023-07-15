package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashBoardPage extends CommonMethods {
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;
    @FindBy(id="menu_pim_viewMyDetails")
    public WebElement myDetailsOption;



    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}
