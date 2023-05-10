package apitesting;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequest {

	public static void main(String[] args) {
		
		Response response=RestAssured.given().baseUri("https://reqres.in").
		when().
			delete("/api/users").
		then().
			statusCode(204)
			.log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		    
	}

}
