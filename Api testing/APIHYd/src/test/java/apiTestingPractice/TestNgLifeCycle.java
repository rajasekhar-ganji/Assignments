package apiTestingPractice;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TestNgLifeCycle extends Parentclass{
	
  @Test
  public void test() {
	 
	Response response =RestAssured.given().when().post("/create").then().log().all().extract().response();
	System.out.println(response.getBody().asString());
  }
}
