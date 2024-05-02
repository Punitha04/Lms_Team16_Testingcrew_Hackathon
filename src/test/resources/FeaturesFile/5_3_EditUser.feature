Feature: Edit User feature
    @tag
  Scenario: Validate row level edit icon
    Given Admin is on Manage User Page	
    When Admin clicks on the edit icon 	
    Then A new pop up with User details appears
  
  Scenario: Check if the fields are updated with valid data
    Given Admin is on User details pop up
    When Update the fields with valid data and click submit
    Then 	Admin gets message "User updated Successfully " and see the updated values in data table
   
  Scenario: Check if the fields are updated with invalid values
    Given Admin is on User details pop up
    When Update the fields with invalid values and click submit
    Then Admin should get Error message
 
  Scenario: Check if the mandatory fields are updated with valid data
    Given Admin is on User details pop up
    When Update the mandatory fields with valid values and click submit
    Then Admin gets message "User updated Successfully " and see the updated values in data table
  
  Scenario: Check if the optional fields are updated with valid data
    Given Admin is on User details pop up
    When Update the optional fields with valid values and click submit
    Then Admin gets message "User updated Successfully " and see the updated values in data table
 
  Scenario: Validate invalid values in the text fields
    Given Admin is on User details pop up
    When Admin enters only numbers or special char in the text fields
    Then Admin should get Error message
 
  Scenario: Validate Cancel button on Edit popup
    Given Admin is on User details pop up
    When Admin clicks Cancel button on edit popup
    Then Admin can see the User details popup disappears and can see nothing changed for particular User

