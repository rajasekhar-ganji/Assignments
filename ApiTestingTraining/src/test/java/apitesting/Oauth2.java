package apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Oauth2 {

	public static void main(String[] args) {
		Response response=RestAssured.given().baseUri("https://api.instantwebtools.net/v1").auth().oauth2("ASFDDGFHCFDFHJHJHGKJ").when().get("/passenger/644635317b3fd8c6a6b716f4").then().statusCode(200).log().all().extract().response();

		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		    
	}

}
