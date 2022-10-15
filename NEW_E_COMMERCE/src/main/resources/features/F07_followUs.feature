@smoke
Feature: F07_FollowUs | users could open followUs links

  Scenario: user opens facebook link
  When user clicks on "facebook" link
  Then "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user opens twitter link
  When user clicks on "twitter" link
  Then "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user opens rss link
  When user clicks on "rss" link
  Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario: user opens youtube link
  When user clicks on "youtube" link
  Then "https://www.youtube.com/user/nopCommerce" is opened in new tab
