package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

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

    @FindBy(css = "img[alt='Avatar']")
    public WebElement tlaImg;

}