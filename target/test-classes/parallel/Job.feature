Feature: This file contains scenarios for the Job Titles

Scenario Outline: To verify the functionality add the job title
Given user  is logged into OrangeHrms using valid credentials
When Go to Menu bar > Admin > Job > Job Title
And Job Titles screen should get open
And Click on Add button
And Add Job Title screen should get open
And Enter the Job Title "<Job Title>"
And Enter the Job Description "<Job Description>"
And upload the Job Specification
And Enter the Note "<Note>"
And Click on Save button
Then Job title should get added
Examples:
|Job Title                             | Job Description                                                                                                                                                             | Note                                                                                             |
|Automation Developer |To develop automated test scripts using selenium as the main testing tool and executing test cases |Should have 4 years experience in automation testing |


Scenario Outline: To verify the functionality add the pay grade
Given user  is logged into OrangeHrms using valid credentials
When Go to Menu bar > Admin > Job >  Pay Grades
And Pay Grades screen should get open
And Click on Add button of Pay Grades
And Add Pay Grades screen should get open
And Enter the name "<Pay Grades Name>"
And Click on Save button of Pay Grades
Then Pay Grades Name should get added
When Click on Add button of Assigned Currencies
And Enter Currency "<currency>"
And Enter Minimum Salary "<Min Salary>"
And Enter Maximum Salary "<Max Salary>"
And Click on Save button of Add Currency
And Click on Cancel button for Edit Pay Grade
Then Pay Grade "<Pay Grades Name>" and Currency "<currency>" should get added
Examples:
|Pay Grades Name|     currency                       | Min Salary | Max Salary |
| Grade 9                  |      United States Dollar |   10000       |  100000     |                    