package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Set;

public class SeleniumUtils {

    public static void switchNewWindow() {

        String mainWindow = WebDriverUtils.getDriver().getWindowHandle();
        Set<String> windows = WebDriverUtils.getDriver().getWindowHandles();

        for (String newWindow : windows) {
            if (!newWindow.equals(mainWindow)) {
                WebDriverUtils.getDriver().switchTo().window(newWindow);
            }
        }
    }

    public static void selectByVisibleText(WebElement element, String textValue) {

        Select select = new Select(element);
        select.selectByVisibleText(textValue);
    }
}