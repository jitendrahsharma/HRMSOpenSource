Feature: This file contains scenarios for the Organization features

    @skip_scenario
    Scenario Outline: To verify the functionality of add the location in the organizations
    Given user is logged into OrangeHrms using valid credentials
    When Go to Menu bar > Admin > Organization > Locations
    And Locations screen should get open
    And Click on Add button of Location
    And Add Location screen should get open
   And add the location data from given sheetName "<SheetName>" and rownumber <RowNumber>
    And Click on Save button of the location
    Then Location  should get added in the organization
     Examples:
     |SheetName|RowNumber| 
     |Locations|0| 
   
    