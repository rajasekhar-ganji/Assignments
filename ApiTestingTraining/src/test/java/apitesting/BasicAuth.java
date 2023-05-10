package apitesting;

import org.apache.commons.codec.binary.Base64;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuth {

	public static void main(String[] args) {

		Response response=RestAssured.given().baseUri("https://api.instantwebtools.net/v1").auth().basic("qwertyuiop", "y76yg7676t").when().get("/passenger/644635317b3fd8c6a6b716f4").then().statusCode(200).log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		    
	}

}
