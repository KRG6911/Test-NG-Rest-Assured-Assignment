Feature:Get call - assignment4

  @assignment4Scenario
  Scenario Outline: Get call request with XML validation
    Given When user enter the getrequest url as "<url>"
    Then User see the response and check the status code as "<status_code>"
    Then display all the currencies
    Then display all the ForwardTypes
    And Validate total outcome types are "<count>" and check system error "<outcome_type>"


    Examples:
      | url                                           | status_code | count | outcome_type |
      | https://www.xignite.com/xCurrencies.asmx?wsdl | 200         | 4     |SystemError   |