@regression
Feature: Check box interaction

Scenario: Click Checkbox field

Given user is on Check Box Page
And clicks on Desktop checkbox
Then data displayed should be "You have selected"