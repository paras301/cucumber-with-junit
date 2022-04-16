package com.company.step.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import java.net.URI;

public class DummyRestApiTest {

	private Scenario scenario;
	private Response response;

	@Before
	public void before(Scenario scenarioVal) {
		this.scenario = scenarioVal;
	}

	@Given("^Get Call to \"(.*)\"$")
	public void get_call_to_url(String url) throws Exception {
		RequestSpecification req = RestAssured.with();
		response = req.given().get(new URI(url)).then().extract().response();
		scenario.log("Response Recieved == " + response.asPrettyString());
	}

	@Then("^Response \"(.*)\" is validated$")
	public void response_is_validated(String responseMessage) {
		JSONObject resJson = new JSONObject(response.asString());
		String message = resJson.getString("message");
		Assert.assertEquals(responseMessage, message);
	}


}
