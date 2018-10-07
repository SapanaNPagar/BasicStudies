Feature: Data driven in Rest Assured test POST1

  @Smoke @Regression
  Scenario Outline: Test data driven111
    Given user update name with "<name>" name
    When user update job with "<job>" name
    Then user post the request
    Then user validate the id is not null

    Examples: 
      | name    | job         |
      | Tom     | Manager     |
      | Jerry   | QA Engineer |
      | Charlin | Director    |

  @Smoke @Important
  Scenario Outline: Test data driven111
    Given user update name with "<name>" name
    When user update job with "<job>" name
    Then user post the request
    Then user validate the id is not null

    Examples: 
      | name | job         |
      | abc  | Manager     |
      | xyz  | QA Engineer |
      | pqr  | Director    |

  @Smoke
  Scenario Outline: Test data driven111
    Given user update name with "<name>" name
    When user update job with "<job>" name
    Then user post the request
    Then user validate the id is not null

    Examples: 
      | name  | job         |
      | neil  | Manager     |
      | ninad | QA Engineer |
      | evaan | Director    |
