package steps;

import impl.UserMgtImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.SeleniumUtils;
import utils.WebDriverUtils;

public class UserMgtSteps {

    UserMgtImpl impl = new UserMgtImpl();

    @When("I open User-Mgt page")
    public void i_open_user_mgt_page() {

        impl.getPage().userMgtLink.click();
    }

    @Then("I should see Login button")
    public void i_should_see_login_button() {

        Assert.assertTrue(impl.getPage().loginBtn.isEnabled());
        System.out.println(impl.getPage().loginBtn.getText());
    }

    @Then("I should see Access DB button")
    public void i_should_see_access_db_button() {

        Assert.assertTrue(impl.getPage().accessDBBtn.isEnabled());
        System.out.println(impl.getPage().accessDBBtn.getText());
    }

    @Then("Title of the page should be {string}")
    public void titleOfThePageShouldBe(String title) {

        switch (title.toLowerCase()) {
            case "register new user":
            case "user db":
            case "login page":
                WebDriverUtils.getDriver().getTitle();
                break;
        }

        Assert.assertTrue(title.equals(WebDriverUtils.getDriver().getTitle()));
        System.out.println(WebDriverUtils.getDriver().getTitle());
        SeleniumUtils.switchNewWindow();
    }

    @And("I click on {string} button")
    public void iClickPage(String clickButton) {

        switch (clickButton.toLowerCase()) {
            case "login":
                impl.getPage().loginBtn.click();
                break;
            case "access db":
                impl.getPage().accessDBBtn.click();
                break;
            case "submit":
                impl.getPage().submitBtn.click();
                break;
        }

        SeleniumUtils.switchNewWindow();
    }

    @Then("Image is displayed")
    public void imageIsDisplayed() {

        Assert.assertTrue(impl.getPage().tlaImg.getAttribute("src").contains("images/logo.jpeg"));
        System.out.println(impl.getPage().tlaImg.getAttribute("src"));
    }

    @And("I input {string} as {string}")
    public void iInputAs(String inputField, String value) {

        impl.inputFields(inputField, value);
    }

    @Then("Title of the page should {string}")
    public void titleOfThePageShouldBeReactShoppingCart(String expectedTitle) {

        Assert.assertEquals(expectedTitle, WebDriverUtils.getDriver().getTitle());
        System.out.println(WebDriverUtils.getDriver().getTitle());
    }

    @Then("I should see all fields displayed on user table")
    public void iShouldSeeAllFieldsDisplayedOnUserTable() {

        Assert.assertTrue(impl.verifyFields());
    }
}