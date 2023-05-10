package apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class APIKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Response response=RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1").header("Authentication","Garrett Winters").when().get("/employees").then().log().all().extract().response();
		
		System.out.println(response.getBody().asString());
		System.out.println("Response status code ===>"+response.getStatusCode());
	}

}
