#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: link on navigation bar


  @tag1
  Scenario: Batch link on navigation bar
    Given Admin on Manage Program page
    When Admin clicks on "Batchlink" on Manage Program page
    Then Admin is re-directed to "Batch page"

    
  @tag2
  Scenario: User link on navigation bar
    Given Admin is on Manage Program page
    When Admin clicks on "Userlink" on Manage Program page
    Then Admin is re-directed to "User page"

    
  @tag3
  Scenario: Logout link on navigation bar
    Given Admin is on Manage Program page
    When Admin clicks on "Logout link" on Manage Program page
    Then Admin is re-directed to "login page"

 
