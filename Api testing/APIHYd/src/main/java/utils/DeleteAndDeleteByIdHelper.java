package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteAndDeleteByIdHelper {
public void deleteRequest() {
	Response response=RestAssured.given().baseUri("https://reqres.in").
			when().
				delete("/api/users").
			then().
				statusCode(204)
				.log().all().extract().response();
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusCode());
	}
public void deleteByIdRequest() {

	Response response=RestAssured.given().baseUri("https://reqres.in").
	when().
		delete("/api/users/3").
	then().
		statusCode(204)
		.log().all().extract().response();
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
}

}
