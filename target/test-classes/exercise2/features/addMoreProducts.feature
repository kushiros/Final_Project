
@tag
Feature: addMoreProducts
  As a user
		I want to be able to add two or more products to the cart and proceed with the purchase
		by placing the order.

  @Buy1Element
  Scenario Outline: buy1Element
    Given As a user i was on "https://www.demoblaze.com/index.html"
    And i want to buy a random product
    When click on "<WebElement>" to buy and i click on addToCart, and click on acept
    When i click on <cart> and i go to "https://www.demoblaze.com/cart.html"
    And click on placeOrder
    And i fill the data
    And click on purchase
    Then i compare the data
	
	    Examples: 
      | WebElement  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
	

  @BuyNElements
  Scenario Outline: BuyNElements
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
