package apitesting;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRequest {

	public static void main(String[] args) {
		
	JSONObject request = new JSONObject();
		

		RestAssured.given().baseUri("https://reqres.in").
		when().
			delete("/api/users/3").
		then().
			statusCode(204)
			.log().all();

		

	}

}
