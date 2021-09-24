Feature: User Management Page Scenarios

  Scenario: Verify title of the page
    Given I navigate to homepage
    When I open User-Mgt page
    Then Title of the page should be Register New User

  Scenario: Verify Login button is present
    Given I navigate to homepage
    When I open User-Mgt page
    Then I should see Login button

  Scenario: Verify Access DB button is present
    Given I navigate to homepage
    When I open User-Mgt page
    Then I should see Access DB button

  Scenario: Verify title of Database page
    Given I navigate to homepage
    When I open User-Mgt page
    When I open Access DB page
    Then Title of the page should be User DB

  Scenario: Verify title of Login page
    Given I navigate to homepage
    When I open User-Mgt page
    When I open Login page
    Then Title of the page should be Login Page