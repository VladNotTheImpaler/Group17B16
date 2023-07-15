package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class MyInfoPage extends CommonMethods {
    @FindBy(xpath = "//a[text()='Qualifications']")
    public WebElement qualifField;
    @FindBy(id = "addLanguage")
    public WebElement addLangButton;

    @FindBy(id = "language_code")
    public WebElement lanField;

    @FindBy(id = "language_lang_type")
    public WebElement fluField;

    @FindBy(id = "language_competency")
    public WebElement compField;
    @FindBy(id = "language_comments")
    public WebElement commentsField;

    @FindBy(id = "btnLanguageSave")
    public WebElement languageSaveButton;

    @FindBy(id = "languageCheckAll")
    public WebElement languageCheckBox;
    @FindBy(id = "delLanguage")
    public WebElement delLangButton;

    public MyInfoPage(){
        PageFactory.initElements(driver,this);
    }
}
