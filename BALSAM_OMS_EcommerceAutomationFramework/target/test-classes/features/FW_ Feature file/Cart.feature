Feature: Shopping Cart Functionality

  Background:
    Given user is in Product Detail/Product List Page

  Scenario: Adding a product to the cart
    When the user adds the product to the cart
    Then the cart should display the correct product name, price, and quantity

  Scenario: Removing a product from the cart
    Given user is having a product in the cart page
    When user removes the product from the cart
    Then the product should be removed from the cart
    And the total price should be updated

  Scenario: Changing quantity of a product in the cart
    Given the user has products in the cart
    When the user changes the quantity of a product in the cart
    Then the cart should update the total price accordingly
    And the cart should display the updated quantity

  Scenario: Removing all products from the cart
    Given user has products in the cart page
    When the user removes all products from the cart page
    Then the cart should be empty
    And the total price should be zero

  Scenario: Viewing the cart content
    Given user has products in the cart page
    When the user views the cart content
    Then all product details in the cart should be correct
    And 'Continue Shopping' CTA displayed
    And 'Checkout' CTA should be displayed to proceed with the checkout process

  Scenario: Applying Promo Code or Discount
    Given the user has products in the cart
    When the user applies Promo code or Discount
    Then the cart should display the adjusted total price
    And the cart should display the 'promo code' or 'discount' applied

  Scenario: Cart Notification for Actions
    Given user adds or removes a product from the cart
    When the cart is updated
    Then the user is displayed with a notification of successful cart actions

  Scenario: Proceeding to Checkout
    Given user has products in the cart page
    When the user clicks on 'Checkout' CTA
    Then the user is taken to the checkout page
    And all items in the cart page are transferred to the checkout page

  Scenario: Cart Calculations during Checkout
    Given the user has products in the cart as a guest user
    When the user logs in
    Then the cart should retain its contents
    And when the user proceeds to checkout
    Then the cart should calculate taxes and shipping charges
    And add them to the total price

  Scenario: Cart Responsiveness on Mobile Devices
    Given user has products in the cart page
    When the user accesses the cart page on various mobile devices
    Then the cart page should be responsive and function correctly

  Scenario: Cart Consistency across Web Browsers
    Given the user has products in the cart
    When the user accesses the cart page on different web browsers
    Then the product should be available in the cart on different web browsers
    And the cart should function consistently and appear correctly
