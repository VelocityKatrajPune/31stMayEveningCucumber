Feature: Multiple data test for coverFox HealthInsurance

Scenario Outline: TC01: Validate CoverFox Health Insurance plan for single person with multiple test data
Given  I am on home page
When I click on get started button
And I click on next button
And I provide age as "<age>" and click on next button
And I provide pincode as "<pincode>", mobNumber as "<mobNum>" and click on continue button
Then matching Health Insurance Plans should be displayed as "<results>"
Examples:
|age|pincode|mobNum|results|
|20|411123|734777777777|90|
|23|411873|6666666666|8|
|100|411046|5555555555|500|



