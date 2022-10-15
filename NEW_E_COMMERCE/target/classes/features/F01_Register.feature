@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: guest user could register with valid data successfully
 Given user go to register page
  When  user select gender type "M"
  And  user enter first name "automation" and last name "tester"
  And user enter date of birth
  And user enter "random" email "test@example.com" field
# if the first string equals "random" then a new email will be registered everytime
  # other wise the e-mail specified in the second string "test@example.com" will be used
  And user fills Password fields "P@ssw0rd" "P@ssw0rd"
  And user clicks on register button
  Then success message is displayed

