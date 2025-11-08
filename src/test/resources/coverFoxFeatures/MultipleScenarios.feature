Feature: CoverFox Health Insurance test
 Background:
Given I am on home page
Given I login to application
@login
Scenario: TC01: Validate CoverFox Health Insurance plan for single person
When I click on get started button
And I click on next button
And I provide age as "34" and click on next button
And I provide pincode as "411046", mobNumber as "8888888888" and click on continue button
Then matching Health Insurance Plans should be displayed as "48"
@payment
Scenario: TC02: Validate CoverFox Car Insurance
When I click on carInsurance button
And I provide valid RTO number and click on view quotes button
And I provide valid details and click on view quotes button
Then I should get plan details
@policy @login
Scenario: TC03: Validate CoverFox Bike Insurance
When  I click on bikeInsurance button
And I provide valid RTO number and click on view quotes button
And  I provide valid details and click on view quotes button
Then I should get plan details