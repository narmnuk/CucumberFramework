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

  Scenario: Create users using cucumber typeRegistry with POJO class
    When I create following users
      | FirstName | LastName       | PhoneNumber  | Email                    | Role    |
      | Jackie    | Natt           | 703-123-4567 | JackieNatt@gmail.com     | Student |
      | Kirstie   | Tiwthong       | 703-765-4321 | Kirstie@gmail.com        | Student |
      | Nattawut  | Siriwongthawan | 703-424-6071 | Siriwongthawan@gmail.com | Student |

  Scenario: Verify multiple credentials' login
    And I click on "Login" button
    Then I validate following credentials are login in with no issue:
      | username        | password   |
      | jwick@gmail.com | john.wick$ |
      | liz@b.com       | liz.blue$  |
      | jwick@gmail.com | john.wick$ |

  @readFromExcel
  Scenario: Create users using Excel file
    When I create users from "Sheet 1" sheet in "Users.xlsx" file

  @readFromExcel
  Scenario: Create users using excel file with random generated user data
    When I create users from "Test Users" sheet in "newUsers.xlsx" file