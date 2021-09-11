Feature: Orangehrm Login Page feature

Scenario: Verify Login page title
Given user in login page
When user gets title of the page
Then  page title should be "OrangeHRM"

Scenario: Verify forgot password link
Given user in login page
When user gets title of the page
Then forgot password link should be "Forgot your password?" displayed

Scenario: verify login with corrent credentials
Given user in login page
When user enters user name "Admin"
And user enters password "admin123"
And user click on Log in button
Then user is on Home Page "OrangeHRM"
 