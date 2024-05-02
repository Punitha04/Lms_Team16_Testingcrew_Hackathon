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
Feature: Manage Program Validation
Background: Logged on the LMS portal as Admin 

  @tag1
    Scenario: Validate landing in Program page
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see URL with "Manage Program"
    
  @tag2
    Scenario Outline: Validate the heading
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a heading with text "Manage Program" in the page    
  
  @tag3
    Scenario: Validate the text and pagination icon below the data table
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below table. 
   @tag4
    Scenario: Validate the footer
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the footer as "In total there are z programs".
    @tag5
    Scenario: Validating the default state of Delete button
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a Delete button on the top left hand side are Disabled
    
    
   @tag6
    Scenario: Validate Add New Program 
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a "+A New Program" button on the program page above the data table
    
   @tag7
    Scenario: Validate that number of records (rows of data in the table) displayed
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the number of records (rows of data in the table) displayed on the page are 5
    
    @tag8
   Scenario: Verify Sort arrow icon on the data table
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
     @tag9
    Scenario: Verify Edit and Delete buttons
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin Should see data table with column names "Program Name", "Program Description", "Program Status", " Edit / Delete"
    
    @tag10
    Scenario: Verify Check box on the data table
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see check box on the left side in all rows of the data table 
    
    @tag11
     Scenario: Verify Edit and Delete buttons
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table
    

   @tag12
    Scenario: Verify Search bar on the Program page
    Given Admin is in dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Search bar with text as "Search..."
    


   
    