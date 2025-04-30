Feature: Notifications and Alerts

  Scenario: Send reminders for upcoming orders and deliveries
    Given a customer named "Rand" has an upcoming meal delivery
    When the delivery is approaching
    Then the system should send a reminder to the customer

  Scenario: Notify users of low-stock ingredients
    Given a kitchen manager views ingredient stock levels
    When the stock level for "Tomatoes" is low
    Then the system should send a low-stock alert to the kitchen manager
