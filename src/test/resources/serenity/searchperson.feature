Feature:
  Working with search on https://pipl.com
  Scenario: use searching
    Given user opens the site
    And user clicks input
    When user search for 'Steve Jobs'
    And user cliks search
    Then user see list of results
    And 'Steve Jobs' should be contained
