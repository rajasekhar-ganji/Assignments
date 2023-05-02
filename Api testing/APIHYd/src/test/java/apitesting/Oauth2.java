package apitesting;

import io.restassured.RestAssured;

public class Oauth2 {

	public static void main(String[] args) {
		RestAssured.given().baseUri("https://api.instantwebtools.net/v1").auth().oauth2("ASFDDGFHCFDFHJHJHGKJ").when().get("/passenger/644635317b3fd8c6a6b716f4").then().statusCode(200).log().all();


	}

}
