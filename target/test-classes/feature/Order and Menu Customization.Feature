Feature: Order and Menu Customization

  Scenario: Allow customers to create custom meal requests
    Given a customer named "Rand" is selecting ingredients for her meal
    When she chooses ingredients "Tomato", "Basil", and "Pasta"
    Then the system should validate that all selected ingredients are compatible

  Scenario: Suggest ingredient substitutions based on dietary restrictions
    Given a customer named "Rand" has a dietary restriction of "Vegan"
    And the ingredient "Cheese" is unavailable
    When the system suggests an alternative
    Then the system should suggest "Vegan Cheese" as a substitute
