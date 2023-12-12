Feature: Payment and Checkout Process

  Background:
    Given the user has items in the shopping cart
    And the user proceeds to checkout

  Scenario: Selecting Payment Method
    Given the user is on the payment page
    When the user selects a payment method
    Then the selected payment method should be highlighted
    And the user should be able to proceed to the next step

  Scenario: Credit Card Payment
    Given the user has selected a credit card as the payment method
    When the user enters valid credit card information
    Then the system should validate the credit card details
    And the user should be able to proceed to the next step

  Scenario: PayPal Payment
    Given the user has selected PayPal as the payment method
    When the user logs in to their PayPal account
    Then the user should be redirected to PayPal for authentication
    And the user should be able to proceed back to the e-commerce site

  Scenario: Alternative Payment Method
    Given the user has selected an alternative payment method
    When the user enters the necessary payment details
    Then the system should validate the information
    And the user should be able to proceed to the next step

  Scenario: Invalid Credit Card Information
    Given the user has entered invalid credit card information
    When the user tries to proceed with the payment
    Then an error message should be displayed
    And the user should be prompted to correct the information

  Scenario: Reviewing Payment Amount
    Given the user is on the payment page
    When the user reviews the payment amount
    Then the displayed amount should match the total order cost
    And the user should be able to proceed with confidence

  Scenario: Confirming Payment
    Given the user has provided valid payment information
    When the user confirms the payment
    Then the system should process the payment
    And the user should receive a payment confirmation

  Scenario: Delayed Payment Processing
    Given the user has initiated a payment
    When the payment processing takes longer than usual
    Then the system should display a loading indicator
    And the user should be informed about the delay

  Scenario: Timeout during Payment Processing
    Given the user has initiated a payment
    When the payment process exceeds the expected time limit
    Then the system should display an error message
    And the user should be prompted to retry the payment

  Scenario: Payment Gateway Temporary Failure
    Given the user is on the payment page
    When the payment gateway experiences a temporary failure
    Then the system should display an error message
    And the user should be guided on how to proceed

  Scenario: Responsive Payment Page on Mobile Devices
    Given the user is accessing the payment page on a mobile device
    When the user completes the payment process
    Then the payment page should be responsive and function correctly

  Scenario: Calculating Shipping Costs
    Then the system should calculate the shipping cost based on the selected shipping method
    And display the calculated shipping cost on the order summary

  Scenario: Qualifying for Free Shipping
    And there is an active promotion for free shipping
    When the user qualifies for free shipping
    Then the system should apply free shipping to the order
    And display "Free Shipping" on the order summary

  Scenario: Multiple Shipping Addresses
    And the user is shipping items to multiple addresses
    When the user proceeds to checkout
    Then the system should calculate shipping costs for each address separately
    And display the total shipping cost for all addresses on the order summary

  Scenario: Applying Shipping Discount
    And there is an active shipping discount promotion
    When the user proceeds to checkout
    Then the system should apply the shipping discount to the calculated shipping cost
    And display the discounted shipping cost on the order summary

  Scenario: Calculating Taxes
    When the user proceeds to checkout
    Then the system should calculate taxes based on the user's location and applicable tax rates
    And display the calculated taxes on the order summary

  Scenario: Changing Shipping Address
    And the user changes their shipping address during checkout
    When the user proceeds to the payment step
    Then the system should recalculate taxes based on the updated shipping address
    And display the revised tax amount on the order summary

  Scenario: Displaying Prices with Taxes
    Given the user is on the product page
    When the user selects a product
    Then the system should display prices with taxes included
    And the order summary should show a breakdown of taxes during checkout
