package stepdef;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class PostCall_ass02 {

    Response response;
    String request_body;
    String mobileName;
    String readResponse;

    @Given("User creates a request body for json postRequest call")
    public void user_creates_a_request_body_for_json_post_request_call() {
        request_body = "{\n" +
                "    \"name\": \"Apple MacBook Pro 16\",\n" +
                "    \"data\": {\n" +
                "        \"year\": 2019,\n" +
                "        \"price\": 1849.99,\n" +
                "        \"CPU model\": \"Intel Core i9\",\n" +
                "        \"Hard disk size\": \"1 TB\"\n" +
                "    }\n" +
                "}";
        System.out.println(request_body);

    }

    @Then("User send postRequest for JSON  with {string}")
    public void user_send_post_request_for_json_with(String url) {
        response = given().contentType(ContentType.JSON).header("Content-Type","application/json; charset=utf-8")
                .body(request_body).when().post(url);
        System.out.println(response.getBody().asString());
    }

    @Then("User read the name from the example table {string}")
    public void user_read_the_name_from_the_example_table(String mName) {
        mobileName = mName;
        System.out.println(mobileName);
    }

    @Then("User check the response and the status code as {string}")
    public void user_check_the_response_and_the_status_code_as(String expectedStatuscode) {
        readResponse = response.getBody().asPrettyString();
        System.out.println(readResponse);
        int statusCode = response.statusCode();
        Assert.assertEquals(String.valueOf(statusCode),expectedStatuscode);

    }

    @Then("User check the year from the response as {string}")
    public void user_check_the_year_from_the_response_as(String checkYear) {
        String y = response.getBody().jsonPath().getString("data.year");
        System.out.println(y);
        Assert.assertEquals(y,checkYear);

    }
    @Then("User check the price from the response as {string}")
    public void user_check_the_price_from_the_response_as(String checkPrice) {
        String p = response.getBody().jsonPath().getString("data.price");
        System.out.println(p);
        Assert.assertEquals(p,checkPrice);
    }
    @Then("User validate the createdAt tag and check not null")
    public void user_validate_the_created_at_tag_and_check_not_null() {
        String createdDate = response.getBody().jsonPath().getString("createdAt");
        System.out.println(createdDate);
        Assert.assertNotNull(createdDate);
    }



}
