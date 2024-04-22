package stepdef;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class GetCall_ass03 {

    Response response;
    String readResponse;

    @Given("User hit the URL as {string}")
    public void user_hit_the_url_as(String url) {
        response = RestAssured.get(url);
    }

    @Then("User read the response and check the status code as {string}")
    public void user_read_the_response_and_check_the_status_code_as(String expectedStatuscode) {

        readResponse = response.getBody().asPrettyString();
        System.out.println(readResponse);
        int statusCode = response.statusCode();
        Assert.assertEquals(String.valueOf(statusCode), expectedStatuscode);

    }

    @Then("User validate if the response contains valid ID as {string} and mobile name")
    public void user_validate_if_the_response_contains_valid_id_as_and_mobile_name(String expectedId) {
        List<Map<String, String>> mobileList = response.jsonPath().getList("$");

        for (Map<String, String> mobile : mobileList) {
            String id = mobile.get("id");
            String mobileName = mobile.get("name");
            if (id.equals(expectedId)) {
                System.out.println("In the response if id is:"+id+" and Mobile Name: " + mobileName);
            }
        }

    }
}

