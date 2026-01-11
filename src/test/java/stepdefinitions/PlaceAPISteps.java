package stepdefinitions;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AddPlaceResponse;
import resources.APIResources;
import utils.ResponseSpecBuilderUtil;
import utils.TestDataBuilder;

public class PlaceAPISteps extends BaseTest{
	
	public PlaceAPISteps() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	RequestSpecification req;
	Response response;
	AddPlaceResponse addPlaceResponse;
	
	@Given("Add Place payload with {string} {string} and {string}")
	public void add_place_payload_with_and(String name, String language, String address) {
		
		 req= given().spec(reqSpec).body(TestDataBuilder.addPlacePayload(name,language,address));
		 
	}
	@When("user calls {string} api with Post http request")
	public void user_calls_api_with_http_request(String apiResource) {

		APIResources resources = APIResources.valueOf(apiResource);
		response= req.when().post(resources.getResource());
		

	}
	@Then("API call is success with the status code {int}")
	public void api_call_is_success_with_the_status_code(Integer int1) {
		addPlaceResponse =response.then().spec(ResponseSpecBuilderUtil.getResSpec()).extract().as(AddPlaceResponse.class);

	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
		String responseString = response.asString();
		JsonPath jsonPath = new JsonPath(responseString);
		
		assertEquals(jsonPath.get(key).toString(), value);

	}

}
