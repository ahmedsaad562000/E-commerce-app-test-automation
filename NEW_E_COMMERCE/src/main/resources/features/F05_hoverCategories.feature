@smoke
  Feature: F05_Hover_Categories | user can select any Category and its SubCategory (if it exists)
    Scenario: user select Random Category
    When User Selects a random Category
    And Check if it has SubCategories
    And User click on the selected Category or random SubCategory
    Then new page title contains the name of the selected Category or SubCategory


#Scenario steps:
#1- in Home page, there are 3 main categories contains sub-categories
#[Computers, Electronics, Apparel]
#2- you need to select random one of the three main categories
#3- you should hover on the selected category
#Note: there's a difference between click and hover command
#How to do Hover action? you could get help from this project
#https://github.com/KhaledAMRS/SeleniumCommands
#4- after hovering, you need to select random one of the three sub cateogries like [Desktops, Notebooks, Software]
#4.1- get the text of this sub-category
#4.2- click on it
#5- after opening sub-category page, you need to get text of the page title
#div[class="page-title"] h1
#6- Assert that the sub-category title is (equal or contains) the one you get it while selecting random sub-category