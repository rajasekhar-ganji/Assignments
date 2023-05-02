package apitesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Oauth1 {

	public static void main(String[] args) {
		RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1").auth().oauth("ASDFGHJJJKKK", "QWETTYYY", "GHHHHIIKK", "ZXCVBNMMNNN").when().get("/employee/2").then().statusCode(200).log().all();


	}

}
