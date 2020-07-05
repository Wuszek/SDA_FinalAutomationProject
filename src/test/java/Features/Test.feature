Feature: Example

  Scenario: Add product to basket
    Given I am on product site
    When I click on add to cart
    Then Product is added to cart

  Scenario: Login to user account
    Given I am on SignIn page
    When I enter my credentials
    Then I am logged on my account
