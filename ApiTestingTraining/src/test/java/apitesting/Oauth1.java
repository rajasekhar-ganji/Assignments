package apitesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Oauth1 {

	public static void main(String[] args) {
		Response response=RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1").header("Authentication","ASDFGHJJJKKK"," QWETTYYY", "GHHHHIIKK", "ZXCVBNMMNNN").when().get("/employees").then().statusCode(200).log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		    

	}

}
