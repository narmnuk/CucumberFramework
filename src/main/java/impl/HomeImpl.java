package impl;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.ConfigReader;
import utils.WebDriverUtils;
import java.util.Set;

public class HomeImpl {

    private static String expected;
    private static String actual;

    public void navigateToHomepage() {

        WebDriverUtils.getDriver().get(ConfigReader.readProperty("url"));
    }

    public void seeLinkText() {

        expected = "Saucedemo";
        actual = WebDriverUtils.getDriver().findElement(By.cssSelector("a#sauce-demo")).getText();

        Assert.assertTrue(actual.equals(expected));
        System.out.println(actual);
    }

    public void clickSauceDemo() {

        Assert.assertTrue(WebDriverUtils.getDriver().findElement(By.cssSelector("a#sauce-demo")).isEnabled());
        WebDriverUtils.getDriver().findElement(By.cssSelector("a#sauce-demo")).click();
    }

    public void getSwagLabsTitle() {

        Set<String> windows = WebDriverUtils.getDriver().getWindowHandles();
        for (String newWindow : windows) {
            WebDriverUtils.getDriver().switchTo().window(newWindow);
        }

        expected = "Swag Labs";
        actual = WebDriverUtils.getDriver().getTitle();

        Assert.assertTrue(actual.equals(expected));
        System.out.println(actual);

        WebDriverUtils.quitDriver();
    }
}