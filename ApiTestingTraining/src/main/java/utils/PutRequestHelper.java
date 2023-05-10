package utils;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequestHelper {
public void putRequest() {
	JSONObject data=new JSONObject();
	data.put("first-name", "raj");
	data.put("last-name", "sekhar");
	System.out.println(data.toJSONString());
Response response=	RestAssured.given().baseUri("https://reqres.in/api").header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(data.toJSONString()).when().put("/users/2").then().statusCode(200).log().all().extract().response();
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	    
}
}
