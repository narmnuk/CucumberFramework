Feature: Home page scenarios

  Scenario: Verify Saucedemo link text
    Given I navigate to homepage
    Then I should be able to see Saucedemo link text
    When I click Saucedemo link text
    Then I should see Swag Labs title