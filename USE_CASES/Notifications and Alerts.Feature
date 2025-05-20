Feature: Notifications System
  As a system user
  I want to receive timely alerts
  So that I don't miss important events

  Scenario Outline: Delivery reminders for scheduled deliveries
    Given a delivery is scheduled on <deliveryDate>
    When it's <notificationTime>
    Then the customer should receive SMS reminder
    With delivery time window: <timeWindow>

    Examples:
      | deliveryDate | notificationTime | timeWindow       |
      | tomorrow     | 8pm previous day | 10:00 AM - 12 PM |
      | next Monday  | 6pm day before   | 2:00 PM - 4 PM   |

  Scenario: Cooking task alert
    Given a chef has tasks starting in 30 minutes
    When the system checks scheduled tasks
    Then it should push notification to chef's device
    With the following details:
      | Meal Name      | Preparation Time |
      | Beef Lasagna   | 45 mins          |
      | Vegan Bowl     | 30 mins          |
      | Chicken Curry  | 50 mins          |

  Scenario: Emergency stock alert
    Given an essential item is out of stock
    When kitchen staff logs in
    Then the system should show urgent banner
    And allow immediate supplier contact
