Feature: Get call - assignment3

  @assignment3Scenario
  Scenario Outline: Validating Get call request
    Given User hit the URL as "<URL>"
    Then User read the response and check the status code as "<status_code>"
    And User validate if the response contains valid ID as "<id>" and mobile name


    Examples:
      | URL                                 | status_code | id |
      | https://api.restful-api.dev/objects | 200         | 8  |
      | https://api.restful-api.dev/objects | 200         | 11 |
      | https://api.restful-api.dev/objects | 200         | 2  |
