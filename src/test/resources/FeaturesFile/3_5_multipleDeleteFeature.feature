
Feature: Multiple Delete Program
Background: Admin is on dashboard page after Login and clicks Program on the navigation bar

Scenario: Validate Common Delete button enabled after clicking on any checkbox
Given Admin is in Manage Program page
When Admin clicks any checkbox in the data table
Then Admin should see common delete option enabled under header Manage Program


Scenario: Validate multiple program deletion by selecting Single checkbox
When Admin clicks on single checkbox in the data table
Given Admin is on Confirm Deletion alert
When Admin click on <YES> button on the alert
Then Admin should land on Manage Program page and can see the selected program is deleted from the data table
When Admin clicks on single checkbox in the data table
And Admin is on Confirm Deletion alert
When  Admin clicks <No> button on the alert
Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table


Scenario: Validate multiple program deletion by selecting multiple check boxes
When Admin clicks on multiple checkbox in the data table
When  Admin clicks delete button under header after selecting multiple checkboxes in the data table
Given Admin is on Confirm Deletion alert
#When Admin click on <YES> button on the alert
#Given Admin should land on Manage Program page and can see the selected programs are deleted from the data table
 #When Admin clicks on multiple checkbox in the data table
#When  Admin clicks delete button under header after selecting multiple checkboxes in the data table
When  User Clicks on <No> button on the alert
Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table



