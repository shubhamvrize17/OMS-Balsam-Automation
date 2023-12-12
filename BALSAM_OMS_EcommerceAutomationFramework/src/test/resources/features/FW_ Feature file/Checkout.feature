Feature: Checkout Process

  Background:
    Given user has items in the cart
    When user clicks on 'Checkout' button 
    Then user should be navigated to Checkout page

  Scenario: Applying Promo Code on Checkout Page
    Given user is on checkout page
    When user enters valid promo code
    Then the total price should be updated accordingly 
    And discount should be reflecting in summary
    And user should be able to proceed to the next step

  Scenario: Providing Billing and Shipping Information
    Given user is on checkout page
    When user provides billing and shipping information
    Then the information should be saved successfully for future purchases
    And the user should be able to proceed to the next step

  Scenario: Reviewing Order Summary
    Given the user is on the checkout page
    When the user reviews the order summary
    Then all items, quantities, and prices should be correct
    And the user should be able to proceed to the next step

  Scenario: Selecting Shipping Method
    Given the user is on the checkout page
    When the user selects a shipping method
    Then the total price should be updated to include shipping costs
    And the user should be able to proceed to the next step

  Scenario: Selecting Payment Method
    Given the user is on the checkout page
    When the user selects a payment method
    Then the user should be prompted to enter payment details
    And the user should be able to proceed to the final step

  Scenario: Guest Checkout
    Given the user is a guest on the checkout page
    When the user completes the checkout process without creating an account
    Then the user should receive an order confirmation
    And the order details should be displayed on the confirmation page

  Scenario: Handling Checkout Errors
    Given the user is on the checkout page
    When an error occurs during the checkout process
    Then an appropriate error message should be displayed
    And the user should be guided on how to resolve the issue

  Scenario: Address Autocomplete
    Given the user is entering their address
    When the user starts typing their address
    Then the system should provide autocomplete suggestions
    And the user should be able to select their address from the suggestions

  Scenario: Responsive Checkout Page on Mobile Devices
    Given the user is accessing the checkout page on a mobile device
    When the user completes the checkout process
    Then the checkout page should be responsive and function correctly
