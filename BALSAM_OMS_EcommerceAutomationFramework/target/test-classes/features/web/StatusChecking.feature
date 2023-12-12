@statuschecking
Feature: statuschecking

  Background: Comman Steps for All Scenarios
    Given User launch the Browser
    And User on login page
    When User enter <username> and <password> for status checking page
      | username    | password |
      | csr_manager | password |
    And User click on the login button
    Then User will be display the home page
    When User enter the <OrderNumber> in the order search text box for status checking page
      | OrderNumber |
      | Y100037047  |
    And Click on the Find order

  @CreatedStatus
  Scenario: Created status
    Then The order should be in Created status

  @ScheduledStatusManual
  Scenario: Scheduled status
    Then The order should be in Scheduled status

  @ReleasedStatusManual
  Scenario: Released status
    Then The order should be in Released status

  @InShipmentStatusManual
  Scenario: InShipment Status
    Then The order should be in Shipment status

  @DeliverdStatusManual
  Scenario: Deliverd Status
    Then The order should be in Deliverd status
