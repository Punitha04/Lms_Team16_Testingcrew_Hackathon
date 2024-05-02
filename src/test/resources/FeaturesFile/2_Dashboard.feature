#Feature: To test the dashboardpage

  #Scenario: Verify after login  admin lands on manage program as dashboard page
   # Given Admin is in Home Page
   # When Admin enter valid credentials  and clicks login button
   # Then Admin should see manage program as header

  #Scenario: Verify the response time
   # Given Admin is in Home Page1
   # When Admin enter valid credentials  and clicks login button1
    #Then Maximum navigation time in milliseconds, defaults to 30 seconds

  #Scenario: Verify broken link
    #Given Admin is in Home Page2
    #When Admin enter valid credentials  and clicks login button2
    #Then HTTP response >= 400. Then the link is broken

  #Scenario: Verify LMS title
    #Given Admin is in Home Page3
    #When Admin enter valid credentials  and clicks login button3
    #Then Admin should see LMS -Learning management system  as title

 # Scenario: Verify  LMS title alignment
    #Given Admin is in Home Page4
    #When Admin enter valid credentials  and clicks login button4
    #Then LMS title should be on the top left corner of the page

 # Scenario: Validate navigation bar text
   # Given Admin is in Home Page5
    #When Admin enter valid credentials  and clicks login button5
    #Then Admin should see correct spelling in navigation bar text
