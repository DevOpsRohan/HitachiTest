Feature: Search Hitachi Solutions 

@Test
Scenario: TC001 User Search with correct(exact word) keyword 
Given the user land of Hitachi portal
When the user click on Search option 
And the user is on the search page
And the user tries to search for "Power Platform Insights: January 2023"
Then the search result should display all the products related 
And the user should be able to select a product from the search results


Scenario: TC002 User Search with correct (Partially word) keyword 
Given the user land of Hitachi portal
When the user click on Search option 
And the user is on the search page
And the user tries to search for "January 2023"
Then the search result should display all the products related
And the user should be able to select a product from the search results

Scenario: TC003 User Search with blank keyword 
Given the user land of Hitachi portal
When the user click on Search option 
And the user is on the search page
And the user tries to search for "  "
Then the search result should display all the products related
And the user should be able to select a product from the search results


Scenario: TC004 User Search with Incorrect keyword 
Given the user land of Hitachi portal
When the user click on Search option 
And the user is on the search page
And the user tries to search for "abcsd"
Then an error message "Sorry, your search didn't return any results." should be displayed

Scenario: TC005 User Search with Alphanumeric keyword 
Given the user land of Hitachi portal
When the user click on Search option 
And the user is on the search page
And the user tries to search for "T23t23"
Then an error message "Sorry, your search didn't return any results." should be displayed






