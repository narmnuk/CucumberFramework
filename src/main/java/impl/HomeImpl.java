package impl;

import pages.HomePage;
import utils.ConfigReader;
import utils.SeleniumUtils;
import utils.WebDriverUtils;

public class HomeImpl {

    private HomePage homePage;

    public HomePage getPage() {

        if (homePage == null)
            homePage = new HomePage();

        return homePage;
    }

    public void navigateToHomepage() {

        WebDriverUtils.getDriver().get(ConfigReader.readProperty("url"));
    }

    public String getLinkText(String linkText) {

        String actualText = "";
        switch (linkText.toLowerCase()) {
            case "saucedemo":
                actualText = getPage().sauceDemoLink.getText();
                break;
            case "e-commerce":
                actualText = getPage().eCommerceLink.getText();
                break;
            case "shopping cart":
                actualText = getPage().shoppingCartLink.getText();
                break;
        }

        return actualText;
    }

    public void clickAndSwitch(String linkText) {

        switch (linkText.toLowerCase()) {
            case "saucedemo":
                getPage().sauceDemoLink.click();
                break;
            case "e-commerce":
                getPage().eCommerceLink.click();
                break;
            case "shopping cart":
                getPage().shoppingCartLink.click();
                break;
        }

        SeleniumUtils.switchNewWindow();
    }
}