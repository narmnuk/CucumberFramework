package steps;

import impl.UserMgtImpl;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.CommonPage;
import pojos.Credentials;
import pojos.User;
import utils.SeleniumUtils;
import utils.WebDriverUtils;
import java.util.List;
import java.util.Map;

public class UserMgtSteps implements CommonPage {

    UserMgtImpl impl = new UserMgtImpl();

    @DataTableType
    public Credentials registerUser1(Map<String, String> entry) {

        return new Credentials(entry.get("username"), entry.get("password"));
    }

    @DataTableType
    public User registerUser2(Map<String, String> entry) {

        return new User(entry.get("FirstName"), entry.get("LastName"), entry.get("PhoneNumber"), entry.get("Email"), entry.get("Role"));
    }

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
            case "instructor page":
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

    @When("I create following users")
    public void iCreateFollowingUsers(List<User> users) {

        for (User eachUser : users) {
            impl.addNewUser(eachUser);
        }
    }

    @Then("I validate following credentials are login in with no issue:")
    public void iValidateFollowingCredentialsAreLoginInWithNoIssue(List<Credentials> credentials) {

        String xpathUsername = String.format(XPATH_TEMPLATE_INPUT_BOX, "Enter Username");
        String xpathPassword = String.format(XPATH_TEMPLATE_INPUT_BOX, "Enter Password");
        String xpathButton = String.format(XPATH_TEMPLATE_BUTTON, "Login");

        for (Credentials eachC : credentials) {
            WebDriverUtils.getDriver().findElement(By.xpath(xpathUsername)).sendKeys(eachC.getUsername());
            WebDriverUtils.getDriver().findElement(By.xpath(xpathPassword)).sendKeys(eachC.getPassword());
            WebDriverUtils.getDriver().findElement(By.xpath(xpathButton)).click();

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebDriverUtils.getDriver().get("http://automation.techleadacademy.io/#/practiceLogin");
            WebDriverUtils.getDriver().navigate().refresh();
        }
    }

    @When("I create users from {string} sheet in {string} file")
    public void iCreateUsersFromSheetInFile(String sheetName, String fileName) {

        impl.addNewUserFromExcelFile(sheetName, fileName);
    }
}