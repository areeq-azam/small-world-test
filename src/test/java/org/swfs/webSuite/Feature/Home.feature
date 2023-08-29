Feature: Home Page SWFS test


  Background: User logs in before every scenario execution
    Given Framework reads the web data from "loginTest.xlsx" having row number "1"
    When user enters "[username]" against field "USERNAME_TEXT_BOX" on "LoginPage"
    And user enters "[password]" against field "PASSWORD_TEXT_BOX" on "LoginPage"
    And user clicks a "LOGIN_BUTTON" on "LoginPage"
    Then user expects visibility of "[message]" against "WELCOME_MESSAGE" on "HomePage"

  @WebSuite @Home
  Scenario: add or remove item
    When user clicks a "ADD_TO_CART_BUTTON" on "HomePage"
    Then user expects visibility of "Remove" against "REMOVE_ITEM_BUTTON" on "HomePage"
    When user clicks a "REMOVE_ITEM_BUTTON" on "HomePage"
    Then user expects visibility of "Add to cart" against "ADD_TO_CART_BUTTON" on "HomePage"

  @WebSuite @Home
  Scenario: cart count badge test
    Given user clicks a "ADD_TO_CART_BUTTON" on "HomePage"
    When user clicks a "ADD_ANOTHER_TO_CART_BUTTON" on "HomePage"
    And user clicks a "ADD_AGAIN_TO_CART_BUTTON" on "HomePage"
    Then user expects visibility of "3" against "ITEM_COUNT_BADGE" on "HomePage"

  @WebSuite @Home
  Scenario: complete user journey test
    Given user clicks a "ADD_TO_CART_BUTTON" on "HomePage"
    Then user expects visibility of "Remove" against "REMOVE_ITEM_BUTTON" on "HomePage"
    Then user expects visibility of "1" against "ITEM_COUNT_BADGE" on "HomePage"
    And user clicks a "CART_BUTTON" on "CheckoutPage"
    And user clicks a "CHECKOUT_BUTTON" on "CheckoutPage"
    When user enters "test name" against field "NAME_FIELD" on "CheckoutPage"
    When user enters "test last name" against field "LASTNAME_FIELD" on "CheckoutPage"
    When user enters "test zip" against field "ZIP_FIELD" on "CheckoutPage"
    And user clicks a "CONTINUE_BUTTON" on "CheckoutPage"
    And user clicks a "FINISH_BUTTON" on "CheckoutPage"
    Then user expects visibility of "Thank you for your order!" against "SUCCESS_MESSAGE" on "CheckoutPage"

