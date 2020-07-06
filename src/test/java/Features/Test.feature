Feature: Example

  Scenario: Add product to basket
    Given I am on product site
    When I click on add to cart
    Then Product is added to cart

  Scenario: Login to user account
    Given I am on SignIn page
    When I enter my credentials
    Then I am logged on my account

  Scenario: Buy product
    Given I am on product site
    When I click on add to cart
    And Product is added to cart
    And I click on checkout
    And I enter my credentials
    And I accept my address
    And I accept terms of service
    And I choose pay by wire
    And I confirm my order
    Then I get order confirmation

  Scenario: Searching for dress
    Given I am on main site
    When I type "Dress" in search bar
    And I click ENTER
    Then Result found shown for "Dress"

  Scenario: Filling contact form and sending message
    Given I am on main site
    When I click on Contact Us button
    And I fill contact form
    And I click Send button
    Then Message is sent
