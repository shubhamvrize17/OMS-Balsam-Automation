@CallCenterApiScenario
Feature: Call Center Api Scenario

  @LoginToken
  Scenario: User logs in with valid credentials and obtains a token
    Given the user provides valid login credentials
    When the user sends a login request to the API
    Then the user should receive a valid token

  @CreateOrder
  Scenario: Create an order number through the API
    Given the user provide valid order creation payload in the file
    When the user sends a create order API request
    And the order should be created successfully with a valid order number

  @CreateShipment
  Scenario: Create shipment through the API
    Given the user provide valid shipment creation payload in the file
    When the user sends a shipment order API request
    Then the API should respond with a successful status code
    And  the response should contain the shipment details
  