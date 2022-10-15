@smoke
Feature: F05_WishList | user can add featured products to WishList
  Background:
    When user clicks on wishlist button of item number 3


  Scenario: add product to wishlist
  Then user will see success message with green background color

  Scenario: add product to wishlist and check Qty
    And user clicks on Wishlist from top right of page
    Then wishList Product Qty will be more than 0




#Scenario 1
#- go to https://demo.nopcommerce.com/
#- you will find 4 products in the middle of the home page [Build your own computer, Apple MacBook Pro 13-inch, HTC
#One M8 Android L 5.0 Lollipop, $25 Virtual Gift Card]
#- if you click on wishlist button ❤️ on this product "HTC One M8 Android L 5.0 Lollipop"
#you will see success message "The product has been added to your wishlist" with green background color
#- Use Soft assertion to verify the following
#success message is displayed
#background color is green
#Note: if you choose to verify Hex value then you will have to convert the color from RGBA to Hex
#Scenario 2
#- go to https://demo.nopcommerce.com/
#- you click on wishlist button ❤️ on same product "HTC One M8 Android L 5.0 Lollipop"
#- wait until this success message with green color to disappear then click on "Wishlist" Tab on the top of the page
#(beside "Register", "Log in" tabs)
#Note: there's easier ways to handle success message like click on x button without having to wait but we will choose this
#way to use explicity wait
#So you should use explicit wait in this step to wait until success message becomes invisible after that click on "Wishlist"
#tab
#- you should get Qty value and verify it's bigger than 0
#Note: You need to decide whether you will choose getText or getAttribute or getCssValue
