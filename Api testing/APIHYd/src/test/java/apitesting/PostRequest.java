package apitesting;


import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequest {

	
	public static void main(String[] args) {
		JSONObject data=new JSONObject();
		data.put("employee_name", "raj");
		data.put("employee_salary", 300000);
		data.put("employee_age", 25);
		data.put("profile_image", "");
		Response resp=RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1").contentType("application/json").body(data.toString()).when().post("/create").then().log().all().extract().response();
		System.out.println(resp.getBody().asString());
		System.out.println(resp.getStatusCode());
		    
	}

}
