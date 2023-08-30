Feature: Web Login SWFS test

  @WebSuite @Login
  Scenario Outline: Valid Login test
    Given Framework reads the web data from "loginTest.xlsx" having row number "<row Number>" and title as "<title>"
    When user enters "[username]" against field "USERNAME_TEXT_BOX" on "LoginPage"
    And user enters "[password]" against field "PASSWORD_TEXT_BOX" on "LoginPage"
    And user clicks a "LOGIN_BUTTON" on "LoginPage"
    Then user expects visibility of "[message]" against "WELCOME_MESSAGE" on "HomePage"
    Examples:
      | row Number |title|
      | 1          |user logins with standard_user |
      | 2          |user logins with problem_user|
      | 3          |user logins with performance_glitch_user|

  @WebSuite @Login
  Scenario Outline: Invalid login test
    Given Framework reads the web data from "InvalidLoginTest.xlsx" having row number "<row Number>" and title as "<title>"
    When user enters "[username]" against field "USERNAME_TEXT_BOX" on "LoginPage"
    And user enters "[password]" against field "PASSWORD_TEXT_BOX" on "LoginPage"
    And user clicks a "LOGIN_BUTTON" on "LoginPage"
    Then user expects visibility of "[message]" against "LOGIN_ERROR_MESSAGE" on "LoginPage"
    Examples:
      | row Number |title|
      | 1          |user logins with empty username and empty password|
      | 2          |user logins with filled username and empty password|
      | 3          |user logins with empty username and filled password|
      | 4          |user logins with wrong user and valid password|
      | 5          |user logins with valid user and wrong password|

  @WebSuite @Login
  Scenario Outline: login & logout test
    Given Framework reads the web data from "loginTest.xlsx" having row number "<row Number>" and title as "<title>"
    When user enters "[username]" against field "USERNAME_TEXT_BOX" on "LoginPage"
    And user enters "[password]" against field "PASSWORD_TEXT_BOX" on "LoginPage"
    And user clicks a "LOGIN_BUTTON" on "LoginPage"
    Then user expects visibility of "[message]" against "WELCOME_MESSAGE" on "HomePage"
    And user clicks a "MENU_BUTTON" on "HomePage"
    And user clicks a "LOGOUT_BUTTON" on "HomePage"
    Then user expects visibility of "[message]" against "LOGIN_MESSAGE" on "LoginPage"
    Examples:
      | row Number |title|
      | 1          |user logins and logs out with standard_user |