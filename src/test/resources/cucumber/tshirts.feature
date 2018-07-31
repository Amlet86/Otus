Feature: TShirts

  Scenario Outline: run automationpractice test for <button>
    Given I am on the automationpractice page
    When I'm moving mouse in women button
    And I'm clicking in "<button>" button
    Then The page opens "<button>" My store

    Examples:
      | button   |
      | T-shirts |
      | Blouses  |

