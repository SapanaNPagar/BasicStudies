Feature: Test Circuit API

  Scenario Outline: Test API response for normal details
    Given user start the rest asured test
    When user hit the get request
    Then user checks 200 the status code
    Then user checks the count or size
    Then user checks "albert_park" value
    Then user checks at path "MRData.CircuitTable.Circuits.circuitId[0]" with the "albert_park" value
    Then user check circuitIds

    Examples: 
      | number | id          |
      |      1 | Manager     |
      |      2 | QA Engineer |
      |      3 | Director    |
