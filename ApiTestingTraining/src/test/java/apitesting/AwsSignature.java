package apitesting;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AwsSignature {

	
	public static void main(String[] args) throws Exception {		
		String url="https://dummy.restapiexample.com/api/v1";
		String accesskey="AVYWDWBDUIWUDWDWWWWN";
		String secretkey="myAWSkey134";
		String Region="awsregion1234";
		String ServiceName="awsServices";
		String SessionToken="ASDWW2H3GHHH56";
		Response response=RestAssured.given().baseUri(url).header("Authentication",accesskey,secretkey,Region,ServiceName,SessionToken).when().get("/employee/4").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		    
		   
		    
		    
		  }
}
	
		

		


