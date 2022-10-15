@smoke
Feature: F06_HomeSliders | user can select all HomeSliders
  Scenario: first slider is clickable on home page
    When user Clicks on Slider number 1
    Then new page is opened with expected url "https://demo.nopcommerce.com/nokia-lumia-1020"

  Scenario: second slider is clickable on home page
    When user Clicks on Slider number 2
    Then new page is opened with expected url "https://demo.nopcommerce.com/iphone-6"