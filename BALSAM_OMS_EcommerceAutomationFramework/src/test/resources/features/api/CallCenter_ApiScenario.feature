@CallCenterApiScenario
Feature: Call Center Api Scenario

  @Login
  Scenario: User generates token for Authorization
    When User send the post login request for getting user token

  @CreateOrder
  Scenario: Verify if order Creation is succesfully using createorderAPI
    When User calls createorderAPI with Post http request 
    Then The API call is success with status code 200

  @CreateShipment
  Scenario: Verify if shipment creation is succesfully using createshipmentAPI
    When User calls createshipmentAPI with Post http request
    Then The API call is success with status code 200

    