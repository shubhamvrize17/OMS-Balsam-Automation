Feature: User Interactions on Product Listing Page

  Background:
    Given that user launches the site
    And user enters valid credentials
    And user clicks on Login button
    And the user navigates to the Product Listing Page

  Scenario: User lands on PLP page with product listings displayed
    Then the user should land on the PLP page with product listings displayed

  Scenario: User lands on the next PLP page
    When the user clicks on the pagination arrow to go to the next page
    Then the user should land on the next PLP page

  Scenario: User lands on the previous PLP page
    When the user clicks on the pagination arrow to go to the previous page
    Then the user should land on the previous PLP page

  Scenario: User lands on the corresponding PLP page by clicking on a specific pagination number
    When the user clicks on a specific pagination number
    Then the user should land on the corresponding PLP page

  Scenario: Products are displayed based on the selected items per page option
    When the user clicks on the "Show" dropdown
    And the user selects a specific number of items to display per page
    Then the products should be displayed based on the selected option

  Scenario Outline: Products are arranged according to the selected sorting option
    When the user clicks on the "Sort" dropdown
    And the user selects "<sorting_option>"
    Then the products should be arranged according to the selected sorting option

    Examples:
      | sorting_option   |
      | Price Low to High |
      | Price High to Low  |
      | Alphabetical       |

  Scenario: Product is added to the user's favorite list
    When the user clicks on the "Add to Favorites" button for a specific product
    Then the product should be added to the user's favorite list

  Scenario: User sees a list of applicable filters and applies them
    And the user clicks on the "Filters" button
    Then the user should see a list of applicable filters
    When the user selects specific filters
    Then the products on the PLP should be filtered accordingly

  Scenario: User clears selected filters
    And the user clicks on the "Filters" button
    And user selects specific filters
    When the user clicks on the "X" button next to a specific filter
    Then the selected filter should be cleared
    When the user clicks on the "Clear All" CTA
    Then all applied filters should be cleared

  Scenario: Product is added to the user's shopping cart
    When the user clicks on the "Add to Cart" button for a specific product
    Then the product should be added to the user's shopping cart

  Scenario: Product is not added to the user's shopping cart
    When the user clicks on the "Add to Cart" button for a specific product
    Then the product should not be added to the user's shopping cart

  Scenario: User views reviews for a specific product
    When the user looks at a specific product
    Then the user should be able to view the reviews of that product

  Scenario: User compares multiple products
    When the user selects multiple products to compare
    And the user clicks on the "Compare" button
    Then the user should be directed to a comparison page with the selected products

  Scenario: User views promotions or discounts for a specific product
    When the user looks at a specific product
    Then the user should be able to see any promotions or discounts for that product

  Scenario: User views badges associated with a specific product
    When the user looks at a specific product
    Then the user should be able to see any badges associated with that product

  Scenario: User views product recommendations on the PLP
    When the user looks at the PLP page content
    Then the user should be able to see product recommendations

  Scenario: User views details about a specific product
    When the user looks at a specific product
    Then the user should be able to see details about that product

  Scenario: User views notification banners on the PLP
    When the user looks at the PLP page content
    Then the user should be able to see any notification banners

  Scenario: User selects a specific layout option
    When the user clicks on the "Layout" option
    And the user selects a specific layout option
    Then the products on the PLP page should be aligned based on the selected layout

  Scenario: User is directed to the Product Detail Page (PDP)
    When the user clicks on a specific product
    Then the user should be directed to the Product Detail Page (PDP)

  Scenario: User is directed to the shopping cart page
    When the user clicks on the "View Cart" CTA
    Then the user should be directed to the shopping cart page

  Scenario: User successfully logs in
    When the User clicks on the signin CTA
    And the User enters the valid credentials
    And the User clicks on the Login button
    Then the User should be able to login successfully

  Scenario: User views detailed information about a product through Quick View
    When the user clicks on the "Quick View" CTA for a specific product
    Then the user should be able to see the detailed information about that product
