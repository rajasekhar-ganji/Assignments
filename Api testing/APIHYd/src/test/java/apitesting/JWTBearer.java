package apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JWTBearer {

	public static void main(String[] args) {
		String url="https://dummy.restapiexample.com/api/v1";
	
		Response response=RestAssured.given().baseUri(url).header("Authentication","JWTBEARER ASDFGHJKLJSNEDEUFIFUHFUR").when().get("/employee/2").then().log().all().extract().response();
	
		System.out.println(response.getBody().asString());
	
		System.out.println(response.getStatusCode());
		    
	}

}