Feature: Post call- assignment1

  @assignment1Scenario
  Scenario Outline: Validation of post call request for XML
    Given post request with "<header>"
    Then User create celsius values as "<celsius>" and its Fahrenheit value "<fah>"
    Then User creates a request body for postRequest call
    Then User send postRequest with "<URL>"
    Then Check the response and status code as "<status_code>"
    And User validate the celsius as "<celsius>" and Fahrenheit "<fah>" value from response


    Examples:
      | header                                | celsius | fah  | URL                                            | status_code |
      | Content-Type: text/xml; charset=utf-8 | 1       | 33.8 | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 2       | 35.6 | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 3       | 37.4 | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 4       | 39.2 | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 5       | 41   | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 6       | 42.8 | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 7       | 44.6 | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 8       | 46.4 | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 9       | 48.2 | https://www.w3schools.com/xml/tempconvert.asmx | 200         |
      | Content-Type: text/xml; charset=utf-8 | 10      | 50   | https://www.w3schools.com/xml/tempconvert.asmx | 200         |




