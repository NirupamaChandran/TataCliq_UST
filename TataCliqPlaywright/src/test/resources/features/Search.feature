Feature: Validate search functionalities

  Scenario: Verify user can search an item
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed
    When user clicks on the first product
#    Then verify whether product detail page is displayed