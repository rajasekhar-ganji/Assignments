package apitesting;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchRequest {

	public static void main(String[] args) {
	JSONObject request = new JSONObject();
		
		request.put("name", "Rajasekhar");
		request.put("job", "software");
		
		System.out.println(request.toJSONString());
		
		
		Response response=RestAssured.given().
			header("Content-Type", "application/json").baseUri("https://reqres.in").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/3").
		then().
			statusCode(200)
			.log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		    

	}

}
