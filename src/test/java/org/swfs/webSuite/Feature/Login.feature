Feature: Web Login SWFS test

  @WebSuite @Login
  Scenario Outline: Valid Login test
    Given Framework reads the web data from "loginTest.xlsx" having row number "<row Number>"
    When user enters "[username]" against field "USERNAME_TEXT_BOX" on "LoginPage"
    And user enters "[password]" against field "PASSWORD_TEXT_BOX" on "LoginPage"
    And user clicks a "LOGIN_BUTTON" on "LoginPage"
    Then user expects visibility of "[message]" against "WELCOME_MESSAGE" on "HomePage"
    Examples:
      | row Number |
      | 1          |
      | 2          |
      | 3          |

  @WebSuite @Login
  Scenario Outline: Invalid login test
    Given Framework reads the web data from "InvalidLoginTest.xlsx" having row number "<row Number>"
    When user enters "[username]" against field "USERNAME_TEXT_BOX" on "LoginPage"
    And user enters "[password]" against field "PASSWORD_TEXT_BOX" on "LoginPage"
    And user clicks a "LOGIN_BUTTON" on "LoginPage"
    Then user expects visibility of "[message]" against "LOGIN_ERROR_MESSAGE" on "LoginPage"
    Examples:
      | row Number |
      | 1          |
      | 2          |
      | 3          |
      | 4          |
      | 5          |
      | 6          |

  @WebSuite @Login
  Scenario Outline: login & logout test
    Given Framework reads the web data from "loginTest.xlsx" having row number "<row Number>"
    When user enters "[username]" against field "USERNAME_TEXT_BOX" on "LoginPage"
    And user enters "[password]" against field "PASSWORD_TEXT_BOX" on "LoginPage"
    And user clicks a "LOGIN_BUTTON" on "LoginPage"
    Then user expects visibility of "[message]" against "WELCOME_MESSAGE" on "HomePage"
    And user clicks a "MENU_BUTTON" on "HomePage"
    And user clicks a "LOGOUT_BUTTON" on "HomePage"
    Then user expects visibility of "[message]" against "LOGIN_MESSAGE" on "LoginPage"
    Examples:
      | row Number |
      | 1          |