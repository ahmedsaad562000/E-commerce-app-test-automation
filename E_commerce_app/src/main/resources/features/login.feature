Feature: user should be able to login to the system
  #test Scenario 1

  Scenario: user login with valid data
  Given open browser
    And user navigates to login page
    When user enter "tomsmith" and "SuperSecretPassword!"
    And User click on login button
    #expected result
    Then user could login succesfully





  #test Scenario 2

  Scenario: user login with Invalid data
    Given open browser
    And user navigates to login page
    When user enter "tomsmithzzz" and "SuperSecretPassword!zzz"
    And User click on login button
    #expected result
    Then user couldn't login succesfully


