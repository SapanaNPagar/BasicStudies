package myCode;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;

public class GoogleLogin_StepDefinitions {
	@Given("launch Google")
	public void launch_Google() {
		Response rs = RestAssured.given().when().get("https://www.google.com/");
		int i = rs.statusCode();
		System.out.println("Status Code is = " + i);
	}

}
