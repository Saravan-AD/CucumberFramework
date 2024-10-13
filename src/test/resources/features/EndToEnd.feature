Feature: Verify end to end scenarios of the application

  @Smoke
  Scenario: Verify user can place order
    Given user open website
    Then verify user is on login page
    When user login username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When user click on add to cart button of the first item
    Then  verify cart icon displays quantity one
    When user click on cart icon
    Then verify user is on cart page
    When user click on checkout button
    Then verify user is on checkout page
    When user fill all checkout details
    And click on Continue button
    Then verify user is on review page
    When user click on Finish button
    Then verify user is on order confirmation page

  Scenario: Verify user can sort products from z to a
    Given user open website
    Then verify user is on login page
    When user login username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When product name is sorted from Z to A
    Then verify the page has been sorted Z to A

  Scenario: Verify user can sort products by price
    Given user open website
    Then verify user is on login page
    When user login username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When product name is sorted high to low price
    Then verify the page has been sorted from high to low price

  Scenario: Verify the quantity items added to the cart is correct
    Given user open website
    Then verify user is on login page
    When user login username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When all the items are added to the cart
    Then verify the quantity of items added is equal to the number displayed in the cart icon
    When user click on cart icon
    Then verify user is on cart page
    And verify total items equals to items added in the cart

  Scenario: Verify the total price is the same as displayed
    Given user open website
    Then verify user is on login page
    When user login username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When all the items are added to the cart
    And user click on cart icon
    Then verify user is on cart page
    And verify total items equals to items added in the cart
    When user click on checkout button
    Then verify user is on checkout page
    When user fill all checkout details
    And click on Continue button
    Then verify user is on review page
    And verify price displayed is equal to the actual price

  Scenario: Verify remove buttons are not displayed after the order is place
    Given user open website
    Then verify user is on login page
    When user login username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When all the items are added to the cart
    And user click on cart icon
    Then verify user is on cart page
    When user click on checkout button
    Then verify user is on checkout page
    When user fill all checkout details
    And click on Continue button
    Then verify user is on review page
    When user click on Finish button
    Then verify user is on order confirmation page
    When user click on back home button
    Then verify user is on home page
    And verify remove buttons are not present

