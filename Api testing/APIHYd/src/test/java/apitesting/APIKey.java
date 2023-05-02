package apitesting;

import io.restassured.RestAssured;

public class APIKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1").header("Authentication","Garrett Winters").when().get("/employee/2").then().log().all();

	}

}
