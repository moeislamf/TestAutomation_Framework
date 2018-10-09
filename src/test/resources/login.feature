Feature: Login
  As a user I am testing login functionality

  @login
  Scenario: Successful login
  Given open browser
  When user login into application
  Then user verify successful login
  And close browser


  
  