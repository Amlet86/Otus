Feature:
  Working with search on https://www.sputnik.ru
  Scenario: use searching
    Given user opens the site
    And user clicks input
    When user search for 'serenity cucumber'
    And user cliks search
    Then user see list of results
    And 'serenity cucumber' should be contained
