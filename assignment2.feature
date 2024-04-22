Feature: Post call- JSON -assignment2

  @assignment2Scenario
  Scenario Outline: Validate the post call request for JSON
    Given User creates a request body for json postRequest call
    Then  User send postRequest for JSON  with "<URL>"
    Then User read the name from the example table "<name>"
    Then User check the response and the status code as "<statusCode>"
    And User check the year from the response as "<year>"
    And User check the price from the response as "<price>"
    And User validate the createdAt tag and check not null


    Examples:
      | URL                                 | name                 | statusCode | year | price   |
      | https://api.restful-api.dev/objects | Apple MacBook Pro 16 | 200        | 2019 | 1849.99 |

