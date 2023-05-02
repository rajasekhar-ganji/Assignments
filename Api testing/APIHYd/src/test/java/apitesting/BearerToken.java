package apitesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {

	public static void main(String[] args) {
	Response response=	RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1").header("Authentication","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9").when().get("/employee/2").then().log().all().extract().response();
	
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		    
	
	}

}