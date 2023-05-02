package apitesting;

import io.restassured.RestAssured;

public class NTLMauth {

	public static void main(String[] args) {
		RestAssured.given().baseUri("https://api.instantwebtools.net/v1").auth().ntlm("myusername123", "mypassword", "mydomain", "work-main").when().get("/passenger/644635317b3fd8c6a6b716f4").then().statusCode(200).log().all();


	}

}
