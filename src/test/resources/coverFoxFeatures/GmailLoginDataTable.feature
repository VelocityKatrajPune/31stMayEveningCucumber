Feature: Study Data table in BDD
Scenario: Test Gmail login
Given I am on login page
When I provide details and click on login button
|userName|password|msg|
|test123|1234|welcome|
|test789|7890|Thank you|
Then I should navigate to inbox


