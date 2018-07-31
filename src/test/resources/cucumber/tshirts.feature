Feature: TShirts

  Scenario Outline: run automationpractice test in <browser>
    Given I am on the automationpractice page in browser "<browser>"
    When I'm moving mouse in women button
    And I'm clicking in women button
    Then The page opens My store

    Examples:
      | browser |
      | remote  |
      | firefox |
      | opera   |
      | ie      |
      | chrome  |
