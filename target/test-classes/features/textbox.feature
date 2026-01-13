@regression @textbox
Feature: Text Box Basic Interaction

Scenario: Enter data in text box fields
Given user is on Text Box Page
When user enters dummy data in text box
And user submits the text box form
Then submitted data should be displayed