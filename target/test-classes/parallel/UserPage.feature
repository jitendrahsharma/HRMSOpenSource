Feature: This file contains scenarios for the Users

/*Background:  
 *Given Provider Willis,Sam is logged into OrangeHRM application using valid credentials
 *|userName|password
 *|Admin|admin123
 */
 
Scenario: To Verify able to add user in the application
    Given user is on Home Page 
     When Go to Admin Menu >User Management > Users
     And system Users Screen should get Open with "System Users"
     And click on Add button
     And add user screen should get open "Add User"
     And select User Roll "Admin"
     And select employee name "Orange"
     And  enter User Name "TestUser"
     And select the status "Enabled"
     And enter the password "Test123456!5@12"
     And enter the confirm password "Test123456!5@12"
     And click on save button
     And go to system user secreen search user "TestUser"
     And click on serach button
     Then verify the added user in the application "TestUser"