Feature: Category Laptop

  Scenario Outline: Add multiple laptops to cart
    Given On lOGIN PAGE
    When valid username is entered
    And valid password is entered
    Then login should be success
    And add "<products>" to cart

    Examples: 
      | products     |
      | Sony vaio i5 |
      | MacBook air  |

  #Scenario Outline: Add product to cart and Calculate Total
    #Given On lOGIN PAGE
    #When valid username is entered
    #And valid password is entered
    #Then login should be success
    #And add "<products>" to cart
    #Then Total amount should be calculated
#
    #Examples: 
      #| products     |
      #| Sony vaio i5 |
      #| MacBook air  |
