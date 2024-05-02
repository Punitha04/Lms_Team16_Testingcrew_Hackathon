Feature: User page validation

@tag1
Scenario: Validate landing in User page
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see the Manage User in the URL
@tag2
Scenario: Validate the heading
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see a heading with text "Manage user" on the page
@tag3
Scenario: Validate the text and pagination icon below the data table
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page y-ending record number on that page z-Total number of records
@tag4
Scenario: Validate data table headers in the User Page
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin Should see the data table with column names "Id", "Name", "Location", "Phone Number", " Edit / Delete"
@tag5
Scenario: Validating the default state of Delete button
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see a Delete button on the top left hand side as Disabled
@tag6
Scenario: Validate "+Add New User" button in User Page
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should be able to see the "+ Add New User" button above the data table
@tag7
Scenario: Validate "+ Assign Student" button in User page
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should be able to see the "+ Assign Student" button above the data table
@tag8
Scenario: Validate "+ Assign Staff" button in User page 
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should be able to see the "+ Assign Staff" button above the data table
@tag9
Scenario: Validate search box in User page
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should be able to see the search text box above the data table
@tag10
Scenario: Validate number of data rows in the data 
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Admin should see two records displayed on the data table
@tag11
Scenario: Verify Check box on the data table
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Each row in the data table should have checkbox
@tag12
Scenario: Verify edit icon on the data table
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Each row in the data table should have a "Edit" icon that is enabled
@tag13
Scenario: Verify delete icon on the data table
Given Admin is dashboard page after Login
When Admin clicks "User" from navigation bar
Then Each row in the data table should have a "Delete" icon that is enabled
@tag14
Scenario: search user by name
Given Admin is dashboard page after Login
When Admin enters user name into search box
Then Admin should see user displayed with the entered name
@tag15
Scenario: Validating the Search with unrelated keyword
Given Admin is dashboard page after Login
When Admin enters the keywords not present in the data table on the Search box 
Then Admin should see zero entries on the data table


