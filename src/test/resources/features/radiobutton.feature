@regression
Feature:Radio Button Interaction

Scenario Outline: Select radio button option
Given user is on radio button page
When user selects "<option>" radio button 
Then selected message should be "<expectedResult>"

Examples:
|	option	|	expectedResult	|
|	Yes		|	Yes				|
|Impressive	|	Impressive		|