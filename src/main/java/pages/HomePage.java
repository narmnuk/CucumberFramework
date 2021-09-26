package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(WebDriverUtils.getDriver(), this);
    }

    @FindBy(css = "a#sauce-demo")
    public WebElement sauceDemoLink;

    @FindBy(css = "a#e-commerce")
    public WebElement eCommerceLink;

    @FindBy(css = "a#shopping-cart")
    public WebElement shoppingCartLink;

}