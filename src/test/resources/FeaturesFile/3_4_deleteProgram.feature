
Feature: Delete Program
Background:  Admin is on dashboard page after Login and clicks Program on the navigation bar
Scenario: delete feature

Given Admin is on Manage Program Page 
When Admin clicks <Delete> button on the data table for any row
Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion


Scenario: Validate details for Confirm Deletion form
Given Admin is on Manage Program Page 
When Admin clicks <Delete> button on the data table for any row
Then Admin should see a message "Are you sure you want to delete <Program name>?""


    Scenario: Click Yes on deletion window
 Given Admin is on Manage Program Page after clicks Program on the navigation bar
When Admin clicks <YES> button on the alert
Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table


 Scenario: Click No on deletion window
Given Admin is on Manage Program Page after clicks Program on the navigation bar
When Admin clicks <NO> button on the alert
Then Admin can see the deletion alert disappears without deleting

Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
When Admin clicks Cancel/Close(X) Icon on Deletion alert
Then Admin can see the deletion alert disappears without any changes



