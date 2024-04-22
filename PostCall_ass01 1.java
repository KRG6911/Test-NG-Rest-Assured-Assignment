package stepdef;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

public class PostCall_ass01 {

    String head;
    String soapBody;
    Response response;
    String celsius ,fahrenheit;
    String readResponse;

    @Given("post request with {string}")
    public void post_request_with(String header) {
        head = header;
        System.out.println(head);

    }

    @Then("User create celsius values as {string} and its Fahrenheit value {string}")
    public void user_create_celsius_values_as_and_its_fahrenheit_value(String cel, String fah) {
        celsius = cel;
        fahrenheit = fah;
    }

    @Then("User creates a request body for postRequest call")
    public void user_creates_a_request_body_for_post_request_call() {
        soapBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "  <soap12:Body>\n" +
                "    <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
                "      <Celsius> "+celsius+" </Celsius>\n" +
                "    </CelsiusToFahrenheit>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";

        System.out.println(soapBody);

    }

    @Then("User send postRequest with {string}")
    public void user_send_post_request_with(String url) {

        String[] parts = head.split(":");
        String headerName = parts[0].trim();
        String headerValue = parts[1].trim();
        Header h1 = new Header(headerName, headerValue);
        response = given()
                .header(h1)
                .body(soapBody)
                .when()
                .post(url);
        System.out.println(response.getBody().asPrettyString());

    }

    @Then("Check the response and status code as {string}")
    public void check_the_response_and_status_code_as(String expectedStatuscode) {

        readResponse = response.getBody().asPrettyString();
        System.out.println(readResponse);
        int statusCode = response.statusCode();
        Assert.assertEquals(String.valueOf(statusCode),expectedStatuscode);
    }

    //in the response only getting CelsiusToFahrenheitResult not celsius value
    @Then("User validate the celsius as {string} and Fahrenheit {string} value from response")
    public void user_validate_the_celsius_as_and_fahrenheit_value_from_response(String expectedCel, String expectedFar) {

        XmlPath xml_path_obj = new XmlPath(response.getBody().asString()).using(xmlPathConfig().namespaceAware(false));
        String c =xml_path_obj.getString("soap:Envelope.soap:Body.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult").trim();
        System.out.println(c);
        Assert.assertEquals(String.valueOf(expectedFar),c);



    }
}
