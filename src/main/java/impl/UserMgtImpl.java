package impl;

import org.junit.Assert;
import pages.UserMgtPage;
import utils.ConfigReader;
import utils.WebDriverUtils;
import java.util.Set;

public class UserMgtImpl extends HomeImpl {

    private UserMgtPage userMgtPage;

    private UserMgtPage getPage() {

        if (userMgtPage == null)
            userMgtPage = new UserMgtPage();
            return userMgtPage;
    }

    public void navigateToUserMgtPage() {

        WebDriverUtils.getDriver().get(ConfigReader.readProperty("url"));
        getPage().userMgtLink.click();
    }

    public void getRegisterNewUserTitle() {

        expected = "Register New User";

        Assert.assertTrue(WebDriverUtils.getDriver().getTitle().equals(expected));
        System.out.println(WebDriverUtils.getDriver().getTitle());
    }

    public void seeLoginButton() {

        Assert.assertTrue(getPage().loginBtn.isEnabled());
        System.out.println(getPage().loginBtn.getText());
    }

    public void seeAccessDBButton() {

        Assert.assertTrue(getPage().accessDBBtn.isEnabled());
        System.out.println(getPage().accessDBBtn.getText());
    }

    public void clickAccessDB() {

        getPage().accessDBBtn.click();
    }

    public void getUserDBTitle() {

        Set<String> windows = WebDriverUtils.getDriver().getWindowHandles();
        for (String newWindow : windows) {
            WebDriverUtils.getDriver().switchTo().window(newWindow);
        }

        expected = "User DB";

        Assert.assertTrue(WebDriverUtils.getDriver().getTitle().equals(expected));
        System.out.println(WebDriverUtils.getDriver().getTitle());
    }

    public void clickLogin() {

        getPage().loginBtn.click();
    }

    public void getLoginTitle() {

        Set<String> windows = WebDriverUtils.getDriver().getWindowHandles();
        for (String newWindow : windows) {
            WebDriverUtils.getDriver().switchTo().window(newWindow);
        }

        expected = "Login Page";

        Assert.assertTrue(getPage().tlaImg.isDisplayed());
        Assert.assertTrue(WebDriverUtils.getDriver().getTitle().equals(expected));
        System.out.println(WebDriverUtils.getDriver().getTitle());
    }
}