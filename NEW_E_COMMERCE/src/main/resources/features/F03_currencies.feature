@smoke
Feature: F03_Currencies | user can change currency

  Scenario: Change Currency
  When user change currency to "Euro"
  Then all shown products should contain the "€" sign

#for loop to
#2.1- use findElements with get(i) method then use getText()
#2.2- save the output inside variable
#2.3- do hard assert to verify that the variable contains "€