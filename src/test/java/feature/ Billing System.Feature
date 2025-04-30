Feature: Billing System

  Scenario: Generate invoices and track financial reports
    Given a customer named "Rand" places an order
    When the order is processed
    Then the system should generate an invoice for the order
    And the system should track the revenue for the order
