Feature: Task Management for Chefs

  Scenario: Assign tasks to chefs and kitchen staff
    Given a kitchen manager assigns tasks to chefs
    When a chef named "John" receives a task
    Then the system should notify Chef John of his assigned task

  Scenario: Notify chefs of scheduled cooking tasks
    Given a chef named "John" has a scheduled task for a meal
    When the scheduled time is near
    Then the system should notify Chef John of the upcoming task
