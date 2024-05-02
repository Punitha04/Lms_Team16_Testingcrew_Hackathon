@Batch
Feature: Validating Batch page

 @TS_BatchPageValidation_01_To_09
 Scenario: Validate landing in Batch page
    Given Admin is on dashboard page after Login
    When Admin clicks Batch from navigation bar
    Then Admin should see the Manage Batch in the URL
    Then Admin should see the Manage Batch in the header
    Then Admin should see the pagination controls under the data table
    Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
    Then Admin should be able to see the Delete icon button that is disabled  
    Then Admin should be able to see the + A New batch button
    Then Each row in the data table should have a checkbox
    Then Each row in the data table should have a edit icon that is enabled
    Then Each row in the data table should have a delete icon that is enabled
    
   @TS_BatchPageValidation_10_&_11
   Scenario: Validate pop up for adding batch
   Given Admin is on dashboard page after Login
   When Admin clicks + A New Batch button
   Then A new pop up with Batch details appears
   Then The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop downStatus as radio buttonNumber of classes as text box
     
   @TS_AddNewBatch_12
   Scenario: Check if description is optional field
   Given A new pop up with Batch details appears
   When Fill in all the fields except description with valid values and click save
   Then The newly added batch should be present in the data table in Manage Batch page
   
   @TS_AddNewBatch_13
   Scenario: Check if the program details are added in data table
   Given A new pop up with Batch details appears
   When Fill in all the fields with valid values and click save
   Then The newly added batch should be present in the data table in Manage Batch page
  
   @TS_AddNewBatch_14
   Scenario: Check for error messages for invalid fields
   Given A new pop up with Batch details appears by clicking +new batch new button
   When any of the fields have invalid values
   Then Error message should appear
   
   @TS_AddNewBatch_15
   Scenario: Check for error messages for mandatory fields
   Given A new pop up with Batch details appears by clicking +new batch new button
   When Any of the mandatory fields are blank
   Then Error message should appear
     
  @TS_EditBatch_22
   Scenario: Validate row level edit icon
   Given The edit icon on row level in data table is enabled
   When Admin clicks the edit icon
   Then A new pop up with Batch details appears   
  
   @TS_EditBatch_23
   Scenario: Check if the fields are updated
   Given Admin clicks the edit icon1
   When Update the fields with valid values and click save
   Then The updated batch details should appear on the data table
   
   @TS_EditBatch_24
   Scenario: Check if the update throws error with invalid valued
   Given Admin clicks the edit icon
   When Update the fields with invalid values and click save
   Then Error message should appear
   
   @TS_EditBatch_25
   Scenario: Check if you get error message when mandatory fields are erased
   Given Admin clicks the edit icon
   When Erase data from mandatory field
   Then Error message should appear
   
   @TS_EditBatch_26
   Scenario: Check if description field is optional in update
   Given Admin clicks the edit icon
   When Erase data from description field
   Then The updated batch details should appear on the data table
   
    @TS_DeleteBatch_16
   Scenario: Validate row level delete icon
   Given The delete icon on row level in data table is enabled
   When Admin clicks the delete icon
   Then Alert appears with yes and No option
   
   @TS_DeleteBatch_18
   Scenario: Validate reject alert
   Given Admin clicks the delete icon1 
   When you click No option
   Then Batch is still listed in data table
   
    @TS_DeleteBatch_17
   Scenario: Validate accept alert
   Given Admin clicks the delete icon
   When You click yes option
   Then Batch deleted alert pops and batch is no more available in data table 
   
   @TS_DeleteMultipleBatches_20
   Scenario: Check for single row delete
   Given One of the checkbox or row is selected
   When Click delete icon below Manage Batch header
   Then The respective row in the data table is deleted
   
   @TS_DeleteMultipleBatches_21
Scenario: Check for multi row delete
Given Two or more checkboxes/row is selected
When Click delete icon below Manage Batch header
Then The respective row in the data table is deleted
   
   