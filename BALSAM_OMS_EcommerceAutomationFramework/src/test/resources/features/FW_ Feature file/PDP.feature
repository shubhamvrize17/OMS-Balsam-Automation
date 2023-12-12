Feature: User Interactions on Product Details Page

  Background:
    Given that user launches the site
    When user enters valid credentials
    And user clicks on Login button

  Scenario: User navigates to Product Details Page from PLP
    And user navigates to PLP
    And user clicks on desired product
    Then the user lands on Product details page
    And user should be able to see the details of the selected product

  Scenario: User directly navigates to Product Details Page from Login
    And user clicks on desired product
    Then the user lands on Product details page

  Scenario: User selects other size on Product Details Page
    And user navigates to PLP
    And user navigates to PDP
    And user clicks on other size
    Then user should see the selected size product

  Scenario: User selects other color on Product Details Page
    And user navigates to PLP
    And user navigates to PDP
    And user clicks on other color
    Then user should see the selected color product

  Scenario: User views selected thumbnail image in PDP
    And user navigates to PLP
    And user navigates to PDP
    And clicks on any thumbnail image
    Then user should see the selected thumbnail image in PDP

  Scenario: User zooms in and out on Product Image in PDP
    And user clicks on Login button
    And user navigates to PLP
    And user navigates to PDP
    And user hovers over product image
    Then user should see the zoomed-in image
    And user removes cursor from product image
    Then user should see the product image in normal size

  Scenario: User adds product to favorite list on PDP
    And user navigates to PLP
    And user navigates to PDP
    And user clicks on favorite icon
    Then the user should be able to add the product to the favorite list

  Scenario: User adjusts quantity on PDP
    And user navigates to PLP
    And user navigates to PDP
    And user clicks on plus to increase the quantity
    Then user should see the increase in quantity
    And user clicks on minus in the quantity box
    Then user should see the decrease in quantity

  Scenario: User views Ratings & Reviews section on PDP
    And user navigates to PLP
    And user navigates to PDP
    Then user should be able to see the ratings & Review section

  Scenario: User gives rating and writes a review on PDP
    And user navigates to PLP
    And user navigates to PDP
    And user clicks on desired product
    And the user is able to see the Ratings & Reviews section
    And user gives a rating to the product
    And writes a review and saves it
    Then user should be able to see the given rating
    And user is able to give a review for the product

  Scenario: User sorts reviews on PDP
    And user navigates to PLP
    And user navigates to PDP
    And user clicks on desired product
    And the user is able to see the Ratings & Reviews section
    And user clicks on dropdown and selects a sort option
    Then user should be able to see the reviews according to the selected sort option
