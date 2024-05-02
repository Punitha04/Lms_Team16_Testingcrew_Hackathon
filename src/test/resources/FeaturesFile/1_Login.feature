Feature: Home Page

 @TCT_140
  Scenario Outline: Verify admin is able to land on home page
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button from "<SheetName>" and <rowNumber>
    Then Admin should land on dashboard page

    Examples: 
      | SheetName | rowNumber |
      | Login     |         1 |
      
 #@TCT_125
  #Scenario: Verify admin is able to land on home page with invalid URL
    #Given Admin launch the browser
    #When Admin gives the invalid LMS portal URL
    #Then Admin should recieve 404 page not found error

  #@TCT_126
  #Scenario: Verify for broken link
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then HTTP response >= 400. link is broken

  #@TCT_124
  #Scenario: Verify admin is able to land on home page
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should land on the home page

  #@TCT_127&130
  #Scenario: Verify the text spelling in the page
   # Given Admin launch the browser
   # When Admin gives the correct LMS portal URL
    #Then Admin should see correct spellings of "User", "Password" fields
    #Then Admin should see "Header" field

  #Scenario: Verify application name
  #Given Admin launch the browser
  #When Admin gives the correct LMS portal URL
  #Then Admin should see  LMS - Learning Management System
 # @TCT_131
  #Scenario: Verify text fields are present
   # Given Admin launch the browser
   # When Admin gives the correct LMS portal URL
   # Then Admin should see two text fields

  #@TCT-132
  #Scenario: Verify text on the first text field
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should User in the first text field

  #@TCT_133
  #Scenario: Verify asterik next to user text
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see * symbol next to user text

  #@TCT_134
  #Scenario: Verify text on the second text field
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should Password in the second text field

 # @TCT_135
  #Scenario: Verify asterik next to password text
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see "*" symbol next to password text

  #@TCT_136
  #Scenario: verify Login is present
    #Given Admin launch the browser
   # When Admin gives the correct LMS portal URL
    #Then Admin should see login button

  #@TCT_137
  #Scenario: Verify the alignment of the login button
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see login button on the centre of the page

  #@TCT_211
  #Scenario: Verify the alignment input field for the login
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see input field on the centre of the page

  #@TCT_138
  #Scenario: Verify input descriptive test in user field
   # Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see user in gray color

  #@TCT_139
  #Scenario: Verify input descriptive test in password field
   # Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see password in gray color
#@TCT_141
 # Scenario Outline: Validate login with invalid credentials from Excel "<SheetName>" and <rowNumber>
    #Given Admin is in Home Page
   # When Admin enter invalid credentials  from excel "<SheetName>" and <rowNumber> and clicks login button
    #Then Error Message "Invalid username and password Please try again"

  #@TCT_142
  #Scenario: Validate login credentials with null username
    #Given Admin is in Home Page
    #When Admin enter "" value only in password and clicks login button
    #Then User gets Error message "please enter your password"

  #@TCT_143
  #Scenario: Validate login credentials with null password
    #Given Admin is in Home Page
    #When Admin enter "" value only in username and clicks login button
    #Then User gets Error message "please enter your user name"

  #@TCT_144
  #Scenario: Verify login button action through keyboard
    #3Given Admin is in Home Page
    #When Admin enter valid credentials  and clicks login button through keyboard
    #Then Admin should land on dashboard page
    #Then Admin Logout of website

 # @TCT_145
 # Scenario: Verify login button action through mouse
    #Given Admin is in Home Page
    #When Admin enter valid credentials  and clicks login button through mouse
   #Then Admin should land on dashboard page
   #Then Admin Logout of website


  

 
 
  