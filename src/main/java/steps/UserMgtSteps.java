package steps;

import impl.UserMgtImpl;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserMgtSteps {

    UserMgtImpl impl = new UserMgtImpl();

    @When("I open User-Mgt page")
    public void i_open_user_mgt_page() throws InterruptedException {

        impl.navigateToUserMgtPage();
    }

    @Then("Title of the page should be Register New User")
    public void title_of_the_page_should_be_register_new_user() {

        impl.getRegisterNewUserTitle();
    }

    @Then("I should see Login button")
    public void i_should_see_login_button() {

        impl.seeLoginButton();
    }

    @Then("I should see Access DB button")
    public void i_should_see_access_db_button() {

        impl.seeAccessDBButton();
    }

    @When("I open Access DB page")
    public void i_open_access_db_page() {

        impl.clickAccessDB();
    }

    @Then("Title of the page should be User DB")
    public void title_of_the_page_should_be_user_db() {

        impl.getUserDBTitle();
    }

    @When("I open Login page")
    public void i_open_login_page() {

        impl.clickLogin();
    }

    @Then("Title of the page should be Login Page")
    public void title_of_the_page_should_be_login_page() {

        impl.getLoginTitle();
    }
}