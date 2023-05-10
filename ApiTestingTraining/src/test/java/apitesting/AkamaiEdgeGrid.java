package apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AkamaiEdgeGrid {

	public static void main(String[] args) {
		 String AccessToken="myaccesstoken";
		String ClientToken="myclienttoken";
		String ClientSecret="myclientsecret";
		String url="https://dummy.restapiexample.com/api/v1";
		String contentType = "application/json";
		Response response=RestAssured.given().baseUri(url).header("Authentication",AccessToken,ClientToken,ClientSecret).when().get("/employees").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		    
	
	}

}
