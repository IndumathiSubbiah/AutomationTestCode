@MVCAppTest
@Credits
Feature: Site Title and Credits

  Scenario: The page title should be shown
    Given the Application URL
    Then the page title should include "TodoMVC"
    Then User should see the credits in the footer
    Then Close the Application