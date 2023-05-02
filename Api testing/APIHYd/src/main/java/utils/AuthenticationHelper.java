package utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationHelper implements AuthenticationHelp{
	public void NoAuthentication() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "/employees");
		String output = response.getBody().asString();
		int statuscode = response.getStatusCode();
		String statusline = response.getStatusLine();
		System.out.println("Response Code===> " + statuscode);
		System.out.println("StatusLine ===> " + statusline);
		System.out.println("Response Body=====>" + output);
	}

	public void AkamaiEdgeGridAuthentication() {
		String AccessToken = "myaccesstoken";
		String ClientToken = "myclienttoken";
		String ClientSecret = "myclientsecret";
		String url = "https://dummy.restapiexample.com/api/v1";
		String contentType = "application/json";
		Response response = RestAssured.given().baseUri(url)
				.header("Authentication", AccessToken, ClientToken, ClientSecret).get("/employees").then().log().all()
				.extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
	}

	public void ApiKeyAuthentication() {
		Response response = RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1")
				.header("Authentication", "Garrett Winters").when().get("/employees").then().log().all().extract()
				.response();
		System.out.println(response.getBody().asString());
		System.out.println("Response status code ===>" + response.getStatusCode());
	}

	public void BearerTokenAuthentication() {
		Response response = RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1")
				.header("Authentication", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9").when().get("/employee/2").then().log()
				.all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
	}

	public void HawkAuthentication() {
		String url = "https://dummy.restapiexample.com/api/v1";
		String hawkid = "myhawkid123";
		String hawkkey = "myhawkkey134";
		String algorithm = "sha256";
		Response response = RestAssured.given().baseUri(url).header("Authentication", hawkid, hawkkey, algorithm).when()
				.get("/employees").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
	}

	public void JWTBearerAuthentication() {
		String url = "https://dummy.restapiexample.com/api/v1";
		Response response = RestAssured.given().baseUri(url)
				.header("Authentication", "JWTBEARER ASDFGHJKLJSNEDEUFIFUHFUR").when().get("/employee/2").then().log()
				.all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
	}

	public void OAuth1() {
		Response response = RestAssured.given().baseUri("https://dummy.restapiexample.com/api/v1").auth()
				.oauth("ASDFGHJJJKKK", "QWETTYYY", "GHHHHIIKK", "ZXCVBNMMNNN").when().get("/employees").then()
				.statusCode(200).log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());

	}

	public void OAuth2() {
		Response response = RestAssured.given().baseUri("https://api.instantwebtools.net/v1").auth()
				.oauth2("ASFDDGFHCFDFHJHJHGKJ").when().get("/passenger/644635317b3fd8c6a6b716f4").then().statusCode(200)
				.log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
	}

	public void NTLMAuthentication() {
		Response response = RestAssured.given().baseUri("https://api.instantwebtools.net/v1").auth()
				.ntlm("myusername123", "mypassword", "mydomain", "work-main").when()
				.get("/passenger/644635317b3fd8c6a6b716f4").then().statusCode(200).log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());

	}

	public void BasicAuth() {

		Response response = RestAssured.given().baseUri("https://api.instantwebtools.net/v1").auth()
				.basic("qwertyuiop", "y76yg7676t").when().get("/passenger/644635317b3fd8c6a6b716f4").then()
				.statusCode(200).log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());

	}

	public void DigestAuth() {
		Response response = RestAssured.given().baseUri("https://api.instantwebtools.net/v1").auth()
				.digest("postman", "password123").when().get("/passenger/644635317b3fd8c6a6b716f4").then()
				.statusCode(200).log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
	}

	public void AWSSignature() {
		String url = "https://dummy.restapiexample.com/api/v1";
		String accesskey = "AVYWDWBDUIWUDWDWWWWN";
		String secretkey = "myAWSkey134";
		String Region = "awsregion1234";
		String ServiceName = "awsServices";
		String SessionToken = "ASDWW2H3GHHH56";
		Response response = RestAssured.given().baseUri(url)
				.header("Authentication", accesskey, secretkey, Region, ServiceName, SessionToken).when()
				.get("/employee/4").then().log().all().extract().response();
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());

	}

}