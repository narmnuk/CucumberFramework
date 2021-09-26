Feature: User Management Page Scenarios

  Background:
    Given I navigate to homepage
    When I open User-Mgt page

  Scenario: Verify title of Register New User page
    Then Title of the page should be "Register New User"

  Scenario: Verify Login button is present
    Then I should see Login button

  Scenario: Verify Access DB button is present
    Then I should see Access DB button

  Scenario: Verify title of Database page
    And I click on "Access DB" button
    Then Title of the page should be "User DB"

  Scenario: Verify title of Login page
    And I click on "Login" button
    Then Title of the page should be "Login Page"

  Scenario: Verify TLA logo is displayed
    And I click on "Login" button
    Then Image is displayed

  Scenario: Verify user registration form
    When I input "FirstName" as "Jackie"
    And I input "LastName" as "Natt"
    And I input "PhoneNumber" as "703-4246-6071"
    And I input "Email" as "jackieNatt@gmail.com"
    And I input "Role" as "Student"
    And I click on "Submit" button
    Then I should see all fields displayed on user table