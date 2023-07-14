package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    // Inside the class, we define instance variables using the @FindBy
    // annotation to locate the web elements.
    @FindBy(id = "txtUsername")
    private WebElement usernameField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "spanMessage")
    public WebElement errorMsg;

    //Initialize the @FindBy-annotated elements using a constructor or a method.
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // we use the getter methods to get this private field in our steps classes
    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }


}
