@smoke
  Feature: F04_Search | user can use search feature
Scenario Outline: User Search By Name
  When user write "<productName>" in the Search Bar
  And clicks On Search Button
  Then user is directed to search results page
  And search page shows relevant results
  And results contains "<productName>"
Examples:
| productName |
| book |
| laptop |
| nike |

Scenario Outline: User Search By sku
  When user write "<productSKU>" in the Search Bar
  And clicks On Search Button
  Then user is directed to search results page
  And search shows one relevant Product
  When user clicks on this Product
  Then The product Serial number contains "<productSKU>"
  Examples:
  | productSKU |
  | SCI_FAITH |
  | APPLE_CAM |
  | SF_PRO_11 |


#Scenario Outline 2 user could search using sku
#1- search with sku (You should pass parameter from Feature File in this step)
#2- After searching, you need to click on the product in search result
#3- Use hard assertion to verify the following
#3.1- get the sku shown in this page then make sure it contains the sku that you are using in search

#Scenario Outline 1 user could search using product name
#Use soft assertion to verify the following
#1- url contains https://demo.nopcommerce.com/search?q=
#2- search shows relevant results
#2.1- Count number of search results using findElements & size()
#2.2- Create for loop and verify each result contains the search word
#You should use toLowerCase() method