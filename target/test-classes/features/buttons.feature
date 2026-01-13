@regression
Feature: Buttons interaction

  Scenario: Verify double click functionality
    Given user is on Buttons page
    When user performs double click
    Then message should be "You have done a double click"

  Scenario: Verify right click functionality
    Given user is on Buttons page
    When user performs right click
    Then message should be "You have done a right click"

  Scenario: Verify dynamic click functionality
    Given user is on Buttons page
    When user performs dynamic click
    Then message should be "You have done a dynamic click"
