package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;
import java.util.List;

public class UserMgtPage {

    public UserMgtPage() {

        PageFactory.initElements(WebDriverUtils.getDriver(), this);
    }

    @FindBy(css = "a[href='#/usermgt']")
    public WebElement userMgtLink;

    @FindBy(css = "button#login-btn")
    public WebElement loginBtn;

    @FindBy(css = "button#access-db-btn")
    public WebElement accessDBBtn;

    @FindBy(css = "img.avatar")
    public WebElement tlaImg;

    @FindBy(css = "input#Firstname")
    public WebElement firstName;

    @FindBy(css = "input#Lastname")
    public WebElement lastName;

    @FindBy(css = "input#Phonenumber")
    public WebElement phoneNumber;

    @FindBy(css = "input#Email")
    public WebElement eMail;

    @FindBy(css = "select#Select-role")
    public WebElement role;

    @FindBy(css = "button#submit-btn")
    public WebElement submitBtn;

    @FindBy(css = "tbody > tr > td")
    public List<WebElement> tdDataTable;

}