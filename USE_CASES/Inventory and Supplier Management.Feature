Feature: Inventory Management
  As a kitchen manager
  I want to track ingredients
  So that we never run out of stock

  Scenario Outline: Low stock alert for different ingredients
    Given <ingredient> is below minimum stock level
    When the inventory is refreshed
    Then the system should show "Low Stock" warning
    And suggest reorder quantity of <reorderQuantity>

    Examples:
      | ingredient     | reorderQuantity |
      | Tomatoes       | 20kg            |
      | Basil Leaves   | 5kg             |
      | Pasta          | 50kg            |

  Scenario: Auto-generate purchase order
    Given an ingredient reaches critical level
    When the system checks inventory at 5pm
    Then it should auto-generate a purchase order
    And email it to the default supplier

  Scenario: Real-time price comparison
    Given multiple suppliers for olive oil
    When viewing inventory for this item
    Then the system should show current prices:
      | Supplier       | Price per Liter |
      | OlivePro Ltd   | $5.20           |
      | Green Harvest  | $4.95           |
      | OrganicOils    | $5.10           |
    And highlight the cheapest option
