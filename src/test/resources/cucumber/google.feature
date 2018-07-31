#Feature: Google
#
#  Scenario Outline: Finding some <search>
#    Given I am on the Google search page
#    When I search for "<search>"
#    Then The page title contains "<expected_word>"
#
#    Examples:
#      | search | expected_word |
#      | cars   | cars          |
#      | boats  | boats         |