@CallCenter_UiScenario
Feature: Call Center Login

  Background: Comman Steps for All Scenarios
    Given User launch Browser
    And The user on login page
    When User enter the <username> and <password>
      | username    | password |
      | csr_manager | password |
    And User click on login button
    Then The user will be display the home page
    When User enter the <OrderNumber> in order search text box
      | OrderNumber |
      | Y100037048  |
    And Click on  Find order
    Then The order summary page should apper

  @ManageCharges
  Scenario: Validate applying header level discount in callcenter
    When Click on "ManageCharges" from Releated Task sub window
    And Click on "Modify charges/Discounts" at header level
    And Select Discount/Refund from the <ChargeCategory> dropdown
      | ChargeCategory  |
      | Discount/Refund |
    And Select "Product discount" from the charge name dropdown
    And Select "Charge Per Line"  from the Applyto dropdown
    And Provide the discount amount in the <ChargeAmount> textbox
      | ChargeAmount |
      |           20 |
    And Provide the note in the Note textbox
      | Note            |
      | add all details |
    And Click on the Apply button
    And Click on Next button Manage Charge Page
    And Click on Confirm button Manage Charges Page
    Then The total amount will be reflected according to discount amount in order Summary screen

  @ManageGiftOptions
  Scenario: Validate the Manage Gift Option from callcenter
    When Click on Manage Gift Option from Releated Task sub window
    Then Click on Next button Manage Gift option page
    Then It display the Manage Gift option

  @CancelProduct
  Scenario: Validate the full order cancellation from call center
    When Click on cancel product from Releated Task sub window
    And Select "Orderedwrongitem" from Reason code dropdown
    And Click on "Select specific lines to cancel" from Choose an option
    And Click on CheckBox in Cancel product Page
    And Click on the Next button Cancel Product Page
    And Click Ok button in pop up screen
    And Click on Confirm button Cancel Product page
    Then Verify the order should be get cancelled on order summury page
