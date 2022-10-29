@MVCAppTest
@Filters
Feature: Completed and Active filter for Todo lists
  In order to remember the things I want to do, as a ToDo MVC user,
  I want to manage my todo list

  Background:
    Given the Application URL
    Given User adds a todo list
      | Feed the cat | Walk the dog |


  #Scenario 1
  Scenario Outline: Completed And Active Todo lists displayed
    When User completes "Walk the dog"
    And User filters the list to show <Filter> tasks
    Then todo list should show the list as:
      | <Item Displayed> |

    Examples:
      | Filter    | Item Displayed |
      | Completed | Walk the dog   |
      | Active    | Feed the cat   |


  #Scenario 2
  Scenario Outline: All Todo lists displayed
    When User completes "Walk the dog"
    And User filters the list to show <Filter> tasks
    Then todo list should show the list as:
      | Feed the cat |
      | Walk the dog |

    Examples:
      | Filter    |
      | All       |

  #Scenario 3
  Scenario: Select all todo lists and Items moved to Completed
    When User selects all items
    And User filters the list to show Completed tasks
    Then todo list should show the list as:
      | Feed the cat |
      | Walk the dog |


  #Scenario 4
  Scenario: Select all todo lists and Clear
    When User selects all items
    And User clicks on Clear completed
    Then todo list items are removed



