package com.sap.f2;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class F2_SD {

	Response resp;
	boolean flag = true;
	ValidatableResponse json;

	@Given("^user start the rest asured test$")
	public void user_start_the_rest_asured_test() {
		resp = RestAssured.given().relaxedHTTPSValidation().when().get("https://ergast.com/api/f1/2017/circuits.json");

	}

	@When("^user hit the get request$")
	public void user_hit_the_get_request() {
		String respString = resp.asString();
		System.out.println(
				"\n========Response String Start=======\n\n" + respString + "\n\n======Response String End=====\n\n");

		Headers heads = resp.getHeaders();
		System.out.println(
				"\n========Headers String Start=======\n\n" + heads + "\n\n========Header String End=======\n\n");

	}

	@Then("^user checks (\\d+) the status code$")
	public void user_checks_the_status_code(int arg1) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(200, resp.statusCode());
	}

	@Then("^user checks the count or size$")
	public void user_checks_the_count_or_size() {
		System.out.println("\n========Check Count start=======\n\n");

		resp.then().assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));

		String limitValue = resp.getBody().jsonPath().getString("MRData.limit");
		Assert.assertEquals("30", limitValue);
		System.out.println("\nLimit Value = " + limitValue + "\n\n");
		System.out.println("\n========Check Count end=======\n\n");

	}

	@Then("^user checks \"([^\"]*)\" value$")
	public void user_checks_value(String matchString) {
		resp.getBody().toString().contains(matchString);
	}

	@Then("^user checks at path \"([^\"]*)\" with the \"([^\"]*)\" value$")
	public void user_checks_at_path_with_the_value(String path, String expValue) {
		String actualCircuitValue = resp.getBody().jsonPath().getString(path);
		Assert.assertEquals(expValue, actualCircuitValue);

	}

	@Then("^user check circuitIds$")
	public void user_check_circuitIds(Map<String, String> responseFields) {
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			json.body(field.getKey(), containsInAnyOrder(field.getValue()));
		}
	}

}
