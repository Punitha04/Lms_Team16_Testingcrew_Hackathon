Feature: Add new user
	
  @AdditionalScenario
  Scenario: Validate User Details from Popup window Heading
    Given Admin is in Manage User Page
    When Admin clicks  Add New User button
    Then Admin should see pop up heading "User Details"

  @tag1
  Scenario: Validate User Details Popup window
    Given Admin is in Manage User Page
    When Admin clicks  Add New User button
    Then Admin should see pop up open for user details with First Name,Middle name, Last Name, Location, phone, email, linkedin url, User Role, Role status, visa status,Undergraduate, postgraduate,time zone ,user comments and user fields along with Cancel , Submit and close buttons

  @tag2
  Scenario: Validate input fields and text boxes in user details form
    Given Admin is in Manage User Page
    When Admin clicks  Add New User button
    Then Admin should see  text boxes for the fields First Name, Middle name, Last Name, Location,phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments"

  @tag3
  Scenario: Validate drop downs in new user form
    Given Admin is in Manage User Page
    When Admin clicks  Add New User button
    Then Admin should see drop downs for the fields User Role,Role status, visa status on user details pop up

  @tag4
  Scenario: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on  User details pop up
    When Admin enters mandatory fields in the form and clicks on submit button
    Then Admin gets message User added Successfully

  #@tag5
 # Scenario: Check if user is created when only optional fields are entered with valid data
  #  Given Admin is on  User details pop up window
    #When Admin skips to add value in mandatory field
    #Then Admin should see error message below the test field and the field will be highlighed in red color

  @tag6
  Scenario: check if user is created when invalid data is entered in all of the fields
    Given Admin is on  User details pop up
    When Admin enters invalid data in all of the  fields in the form and clicks on submit button
    Then Admin gets error message and user is not created

  @tag7
  Scenario: Empty form submission
    Given Admin is on  User details pop up
    When Admin clicks on submit button without entering data
    Then user wont be created and Admin gets error message

  @tag8
  Scenario: Validate Cancel/Close(X) icon on User Details form
    Given Admin is on  User details pop up
    When Admin clicks Cancel or Close(X) Icon on User Details form
    Then User Details popup window should be closed without saving

  @tag9
  Scenario: Validate Cancel button on User Details form
    Given Admin is on  User details pop up
    When Admin clicks Cancel button
    Then Admin can see the User details popup disappears without adding any user

  @tag10
  Scenario: Check if the user details are added in data table
    Given Admin is on  User details pop up
    When Fill in all the fields with valid values and click submit
    Then The newly added user should be present in the data table in Manage User page
