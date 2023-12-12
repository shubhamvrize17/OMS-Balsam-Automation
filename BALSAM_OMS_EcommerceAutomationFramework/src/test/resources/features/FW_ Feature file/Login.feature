Feature: User Login on the Website

  Scenario: User Login with Invalid Username
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the wrong or invalid username
    And the User enters the password
    And the User clicks on the Login button
    Then the User should get the error message

  Scenario: User Login with Wrong Password
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the username
    And the User enters the wrong password
    And the User clicks on the Login button
    Then the User should get the error message

  Scenario: Successful User Login
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the valid username
    And the User enters the correct password
    And the User clicks on the Login button
    Then the User should be able to login successfully

  Scenario: View Password Text
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the valid username
    And the User enters the correct password
    And the User verifies the password
    And the User clicks on the eye icon in the password field
    Then the User should be able to see the text of the password

  Scenario: Tab Key Login
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the valid username
    And the User enters the correct password
    And the User clicks on the Tab button on the keyboard
    Then the User should be able to login successfully

  Scenario: Enter Key Login
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the valid username
    And the User enters the correct password
    And the User clicks on the Enter button on the keyboard
    Then the User should be able to login successfully

  Scenario: User Login with Inactive Username
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the inactive username
    And the User enters the password
    And the User clicks on the Login button
    Then the User should get the error message

  Scenario: Navigate Back and Forward after Login
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the username
    And the User enters the password
    And the User clicks on the Login button
    And the User clicks on the back arrow of the browser
    Then the User should go back to the previous page
    And the User should be able to login successfully and land on the home page
    And the User clicks on the forward arrow from the browser
    Then the User should be logged in already

  Scenario: Session Timeout and Login
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the username
    And the User enters the password
    And the User clicks on the Login button
    And the User leaves the site idle for some time (till the threshold time)
    Then the User should be able to see the page as logged out
    And the User should be able to see the page after session timeout if the user logs in again
    And the User should be able to navigate to any page (PLP)
    And the User should land on that page (PLP)
    And the User leaves the site idle for some time (till the threshold time)
    And the User should be able to see the page as logged out
    And the User should again log in with valid credentials
    Then the User should be able to log in successfully and land on the same page where they were logged out (PLP)

  Scenario: Forgot Password Popup
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User clicks on the Forgot Password CTA
    Then the User should get a popup to enter a username

  Scenario: Logout and Home Page Landing
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the username
    And the User enters the password
    And the User clicks on the Login button
    And the User clicks on the logout button
    Then the User should land on the home page

  Scenario: Password Reset and Login Failure
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User clicks on the Forgot Password CTA
    Then the User should get a popup to enter a username
    And the User enters the username
    And the User clicks on continue
    And the User should see the message that the password reset link is sent to their email
    And the User resets the password
    And the User comes back to the login page and enters the username
    And the User enters the old password and clicks on the login button
    Then the User should get an error message

  Scenario: Site Status After Browser Close and Relaunch
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the valid username
    And the User enters the correct password
    And the User clicks on the Login button
    And the User opens another tab and goes to the site
    Then the User should be able to see the site as logged in
    And the User verifies the login functionality by closing the browser after login
    And the User should close the browser and launch the site again by launching the browser
    And the User should land on the site as a guest user

  Scenario: Account Lockout Popup
    Given the User launches the website
    When the User clicks on the signin CTA
    And the User enters the wrong or invalid username
    And the User enters the password
    And the User clicks on the Login button
    And the User follows the same steps for 2 times
    Then the User should get a popup indicating that the account is locked
