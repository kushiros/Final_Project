@tag
Feature: addMoreProducts
  As a user
  I want to be able to add two or more products to the cart and proceed with the purchase by placing the order.


@BuyNElements
  Scenario Outline: buyNProducts
    Given As a user I am on "https://www.demoblaze.com/index.html"
    And I want to buy the following products:
      | ProductId   |
      | <ProductIds> |
    And I go to the Cart Page
    When I click on "Place Order" and fill in the data "<name>" "<credit_card>":
    And I click on "Purchase"
    Then I should see the purchase information

    Examples:
      | ProductIds   			| name       | credit_card      |
      | 10,5,7,9,10,12,2   | manolo     | 123131231123     |
      | 2,4,6,8 					| ricardo    | maiame           |
      | 7,5,3,7,2 			  | michi miau | miau             |
      | 2,4,6,8           | miseria    | maiame           |