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
Feature: Add New Program
    @tag1
    Scenario: Validate Program Details Popup window
    Given Admin is in Manage Program Page
    When Admin clicks <A New Program>button
    Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
    
    @tag2
    Scenario: Validate input fields and their text boxes in Program details form 
    Given Admin is on Manage Program Page
    When Admin clicks <A New Program>button
    Then Admin should see two input fields and their respective text boxes in the program details window
    
    @tag3
    Scenario: Validate radio button for Program Status 
    Given Admin is on Manage Program Page
    When Admin clicks <A New Program>button
    Then Admin should see two radio button for Program Status
    
      @tag4
    Scenario: Empty form submission
    Given Admin is on "Program Details" Popup window
    When Admin clicks <Save>button without entering any data
    Then Admin gets Error message alert 
    
     
    @tag5
    Scenario Outline: Enter only Program Name
    Given Admin is on "Program Details" Popup window
    When Admin enters only Program Name in text box and clicks Save button from  "<sheetName>" and <rowNumber>
    Then Admin gets a message alert 'Description is required.'
    
    Examples: 
      | sheetName  | rowNumber |
      | addProgram |         0 |
      
      @tag6
    Scenario Outline: Enter only Program Description
    Given Admin is on "Program Details" Popup window
    When Admin enters only Program Description in text box and clicks Save button from  "<sheetName>" and <rowNumber>
    Then Admin gets a message alerts 'Program name is required.'
    
    Examples: 
      | sheetName  | rowNumber |
      | addProgram |         0 |

    @tag7
    Scenario: Select Status only
    Given Admin is on "Program Details" Popup window
    When Admin selects only Status and clicks Save button
    Then Admin get a message alert 'Program name is required.' and 'Description is required.'
    
     @tag8
    Scenario Outline: Validate invalid values on the text column
    Given Admin is on "Program Details" Popup window
    When Admin enters only numbers or special char in name and desc column from  "<sheetName>" and <rowNumber>
    Then Admin get a Error message alert 
    Examples: 
      | sheetName  | rowNumber |
      | addProgram |         0 |
    
       
    @tag9
    Scenario: Validate Cancel/Close(X) icon on Program Details form
    Given Admin is on "Program Details" Popup window
    When Admin clicks Cancel Icon on Program Details form
    Then Program Details popup window should be closed without saving
    
     @tag10
    Scenario Outline: Validate Save button on Program Details form
    Given Admin is on "Program Details" Popup window
    When Enter all the required fields with valid values and click Save button from  "<sheetName>" and <rowNumber>
    Then Admin gets a message "Program Created Successfully" alert and able to see the new program added in the data table
    Examples: 
      | sheetName  | rowNumber |
      | addProgram |         0 |

    
    
    
  

      
  
    
    