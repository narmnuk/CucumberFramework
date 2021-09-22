package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

    private static WebDriver driver = null;

    public static WebDriver getDriver() {

        if (driver == null)
            browserDriver();
            return driver;
        }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void closeDriver() {

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void main(String[] args) {

//        getDriver().findElement(By.cssSelector("")).click();
//        getDriver().quit();
    }

    private static void browserDriver() {   // <---private uses only this class

        switch (ConfigReader.readProperty("browser")) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }
}