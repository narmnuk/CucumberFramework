package impl;

import org.junit.Assert;
import pages.HomePage;
import utils.ConfigReader;
import utils.WebDriverUtils;
import java.util.Set;

public class HomeImpl {

    private HomePage homePage;

    private HomePage getPage() {

        if (homePage == null)
            homePage = new HomePage();
            return homePage;
    }

    public String expected;
    public String actual;

    public void navigateToHomepage() {

        WebDriverUtils.getDriver().get(ConfigReader.readProperty("url"));
    }

    public void seeLinkText() {

        expected = "Saucedemo";
        actual = getPage().sauceDemoLink.getText();

        Assert.assertTrue(actual.equals(expected));
        System.out.println(actual);
    }

    public void clickSauceDemo() {

        Assert.assertTrue(getPage().sauceDemoLink.isEnabled());
        getPage().sauceDemoLink.click();
    }

    public void getSwagLabsTitle() {

        Set<String> windows = WebDriverUtils.getDriver().getWindowHandles();
        for (String newWindow : windows) {
            WebDriverUtils.getDriver().switchTo().window(newWindow);
        }

        expected = "Swag Labs";

        Assert.assertTrue(WebDriverUtils.getDriver().getTitle().equals(expected));
        System.out.println(WebDriverUtils.getDriver().getTitle());
    }
}