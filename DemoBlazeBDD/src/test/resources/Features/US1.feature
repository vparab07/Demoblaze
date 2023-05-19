Feature: Category Phone

  Scenario: Valid login
    Given On lOGIN PAGE
    When valid username is entered
    And valid password is entered
    Then login should be success

  Scenario: Add mobile phone to cart
    Given On lOGIN PAGE
    When valid username is entered
    And valid password is entered
    Then login should be success
    And add product to cart
    
  #Scenario: Place order
    #Given On lOGIN PAGE
    #When valid username is entered
    #And valid password is entered
    #Then login should be success
    #And add product to cart
    #And Place order
