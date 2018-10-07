package com.sap.f1;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class F1_SD {

	@Given("launch Google")
	public void launch_Google() {
		Response rs = RestAssured.given().when().get("https://www.google.com/");
		int i = rs.statusCode();
		System.out.println("Status Code is = " + i);
	}

}
