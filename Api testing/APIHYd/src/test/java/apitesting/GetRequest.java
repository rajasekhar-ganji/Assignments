package apitesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.AuthenticationHelper;

public class GetRequest {
	
	public static void main(String[] args) {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RequestSpecification request=RestAssured.given();
		Response response=request.request(Method.GET,"/employees");
		String output=response.getBody().asString();
		int statuscode=response.getStatusCode();
		String statusline=response.getStatusLine();
		System.out.println("Response Code===> "+statuscode);
		System.out.println("StatusLine ===> "+statusline);
		System.out.println("Response Body=====>"+output);
	}

}
