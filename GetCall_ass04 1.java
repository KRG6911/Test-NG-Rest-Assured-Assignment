package stepdef;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class GetCall_ass04 {

    Response response;
    String readResponse;

    @Given("When user enter the getrequest url as {string}")
    public void when_user_enter_the_getrequest_url_as(String url) {
        response = RestAssured.get(url);
    }

    @Then("User see the response and check the status code as {string}")
    public void user_see_the_response_and_check_the_status_code_as(String expectedStatuscode) {
        readResponse = response.getBody().asPrettyString();
        System.out.println(readResponse);
        int statusCode = response.statusCode();
        Assert.assertEquals(String.valueOf(statusCode),expectedStatuscode);
    }

    @Then("display all the currencies")
    public void display_all_the_currencies() {
        XmlPath xmlPath = new XmlPath(response.getBody().asString());
        List<String> currencies =xmlPath.getList("definitions.types.schema.simpleType[1].restriction.enumeration.@value");
        for (String currency : currencies) {
            System.out.println(currency);
        }
    }

    @Then("display all the ForwardTypes")
    public void display_all_the_forward_types() {
        XmlPath xmlPath = new XmlPath(response.getBody().asString());
        List<String> forwardTypes =xmlPath.getList("definitions.types.schema.simpleType[2].restriction.enumeration.@value");
        for (String types : forwardTypes) {
            System.out.println(types);
        }

    }

    @Then("Validate total outcome types are {string} and check system error {string}")
    public void validate_total_outcome_types_are_and_check_system_error(String expectedCount, String expectedType) {
        XmlPath xmlPath = new XmlPath(response.getBody().asString());
        List<String> outcomeTypes =xmlPath.getList("definitions.types.schema.simpleType[0].restriction.enumeration.@value");
        int count = outcomeTypes.size();
        System.out.println("outcome types count:"+count);
        Assert.assertEquals(String.valueOf(count),expectedCount);

        for (String outcome : outcomeTypes) {
            if (outcome.contains(expectedType)) {
                System.out.println(outcome);
                break;
            }
        }
    }

}
