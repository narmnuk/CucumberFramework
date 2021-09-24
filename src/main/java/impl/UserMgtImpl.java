package impl;

import org.junit.Assert;
import pages.UserMgtPage;
import utils.WebDriverUtils;
import java.util.Set;

public class UserMgtImpl {

    private UserMgtPage userMgtPage;

    private UserMgtPage getPage() {

        if (userMgtPage == null)
            userMgtPage = new UserMgtPage();

        return userMgtPage;
    }

    public void navigateToUserMgtPage() {

        getPage().userMgtLink.click();
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

    public void clickLogin() {

        getPage().loginBtn.click();
    }

    public void getTitle() {

        Set<String> windows = WebDriverUtils.getDriver().getWindowHandles();
        for (String newWindow : windows) {
            WebDriverUtils.getDriver().switchTo().window(newWindow);

            switch (WebDriverUtils.getDriver().getTitle()) {

                case "Register New User":
                    Assert.assertTrue(WebDriverUtils.getDriver().getTitle().equals("Register New User"));
                    break;

                case "User DB":
                    Assert.assertTrue(WebDriverUtils.getDriver().getTitle().equals("User DB"));
                    break;

                case "Login Page":
                    Assert.assertTrue(getPage().tlaImg.isDisplayed());
                    Assert.assertTrue(WebDriverUtils.getDriver().getTitle().equals("Login Page"));
                    break;

                default:
                    break;
            }
        }

        System.out.println(WebDriverUtils.getDriver().getTitle());
    }
}