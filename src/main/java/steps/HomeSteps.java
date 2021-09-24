package steps;

import impl.HomeImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomeImpl impl = new HomeImpl();

    @Given("I navigate to homepage")
    public void i_navigate_to_homepage() {

        impl.navigateToHomepage();
    }

    @Then("I should be able to see Saucedemo link text")
    public void i_should_be_able_to_see_saucedemo_link_text() {

        impl.seeLinkText();
    }

    @When("I click Saucedemo link text")
    public void i_click_saucedemo_link_text() {

        impl.clickSauceDemo();
    }

    @Then("I should see Swag Labs title")
    public void i_should_see_swag_labs_title() {

        impl.getSwagLabsTitle();
    }
}