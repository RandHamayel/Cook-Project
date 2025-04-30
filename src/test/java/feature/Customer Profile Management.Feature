Feature: Customer Profile Management

  Scenario: Store dietary preferences and allergies
    Given a customer named "Rand"
    When she provides dietary preference "Vegan" and allergy "Peanuts"
    Then the system should save the dietary preference "Vegan" and allergy "Peanuts"

  Scenario: Track past orders and personalized meal plans
    Given a customer named "Rand" with order history
    When she views her order history
    Then the system should display her past orders and suggest personalized meal plans
