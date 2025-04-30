Feature: Inventory and Supplier Management

  Scenario: Track available ingredients and suggest restocking
    Given a kitchen manager views ingredient stock levels
    When an ingredient like "Tomatoes" is low
    Then the system should suggest restocking the ingredient

  Scenario: Integrate with suppliers for real-time pricing and ordering
    Given the system fetches real-time ingredient prices from suppliers
    When the price of "Tomatoes" is updated
    Then the system should notify the kitchen manager of the updated price
