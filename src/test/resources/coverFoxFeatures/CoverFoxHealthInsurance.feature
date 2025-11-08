Feature: CoverFox Health Insurance test
Scenario: TC01: Validate CoverFox Health Insurance plan for single person
Given I am on home page
When I click on get started button
And I click on next button
And I provide age as "34" and click on next button
And I provide pincode as "411046", mobNumber as "8888888888" and click on continue button
Then matching Health Insurance Plans should be displayed as "48"

Scenario: TC02: Validate CoverFox Health Insurance plan for single person
Given I am on home page
When I click on get started button
And I click on next button
And I provide age as "34" and click on next button
And I click on continue button
Then validate error messages