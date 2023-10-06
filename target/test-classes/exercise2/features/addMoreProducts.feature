@tag
Feature: addMoreProducts
  As a user
  I want to be able to add two or more products to the cart and proceed with the purchase by placing the order.

  @Buy1Element
  Scenario Outline: buyProduct
    Given As a user I am on "https://www.demoblaze.com/index.html"
    When I click on the product with ID "<ProductId>"
    Then I go to the product details page
    When I click on the Add to Cart button
    Then I go to the Cart Page
    When I click on "Place Order" and fill in the data "<name>" "<credit_card>":
    And I click on "Purchase"
    Then I compare the data

    Examples:
      | ProductId | name     | credit_card      |
      | 1         | manolo   | 123131231123     |
      | 5         | ricardo  | maiame           |
@BuyNElements
  Scenario Outline: buyNProducts
    Given As a user I am on "https://www.demoblaze.com/index.html"
    And I want to buy the following products:
      | ProductId   |
      | <ProductIds> |
    Then I go to the Cart Page
    When I click on "Place Order" and fill in the data "<name>" "<credit_card>":
    And I click on "Purchase"
    Then I compare the data

    Examples:
      | ProductIds   | name     | credit_card      |
      | 1, 5, 7, 9   | manolo   | 123131231123     |
      | 2, 4, 6, 8   | ricardo  | maiame           |