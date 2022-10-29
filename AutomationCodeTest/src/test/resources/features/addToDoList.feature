@MVCAppTest
@AddItem
Feature: Adding new todos

  In order to remember the things I want to do, as a ToDo MVC user,
  I want to manage my todo list

  Background:
    Given the Application URL

  #Scenario 1
  Scenario: User should be suggest when adding todo items for the first time
    When the Application should suggest how to add them for first time

  #Scenario 2
  Scenario: User Adds an Item
    And User has not entered any list item
    When User adds "Set the Alarm"
    Then todo list should show the list as:
      | Set the Alarm |


  #Scenario 3
  Scenario: Adding a set of items to existing list
    And User has not entered any list item
    When User adds "Reset the Alarm"
    When User adds "Take Medicine After Food"
    Then todo list should show the list as:
      | Set the Alarm            |
      | Take Medicine After Food |
      | Reset the Alarm          |
    And the remaining item count should show "3 items left"

  #Scenario 4
  Scenario: Edit the items added
    Then User sees a suggestion to edit the item added
    And Double click on "Set the Alarm" and edit the text as " - Edited"


