Feature: Search for self-made ninja on a webpage

Scenario: Search for self-made ninja and print the first link
Given I launch the browser
And I navigate to the webpage URL
When I click the search icon
And I enter "self-made ninja" in the search field
And I click the search button
Then I print the text of the first search result link
And I close the browser
