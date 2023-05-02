package apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HawkAuth {

	public static void main(String[] args) {
		String url="https://dummy.restapiexample.com/api/v1";
		String hawkid="myhawkid123";
		String hawkkey="myhawkkey134";
		String algorithm="sha256";
		
		Response response=RestAssured.given().baseUri(url).header("Authentication",hawkid,hawkkey,algorithm).when().get("/employees").then().log().all().extract().response();
	
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());

	}

}
