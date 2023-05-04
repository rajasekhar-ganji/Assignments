package apiTestingPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Parentclass {
	private Response response;
	private JSONObject data;
	private Properties prop;
	 @BeforeSuite
	  public void beforeSuite() throws Exception {
			 prop=new Properties();
				FileInputStream input=new FileInputStream("C:\\Users\\rajasekhar.ganji\\eclipse-workspace\\APIHYd\\src\\test\\resources\\Properties.properties");
				prop.load(input);
				 RestAssured.baseURI=prop.getProperty("url");
				  System.out.println(prop.getProperty("url"));
				 
	 }
	  @BeforeTest
	  public void beforeTest() throws Exception {
		   data=new JSONObject();
			data.put("employee_name", prop.getProperty("name"));
			data.put("employee_salary", prop.getProperty("salary"));
			data.put("employee_age",prop.getProperty("age"));
			data.put("profile_image", "");
			RestAssured.given().body(data.toJSONString());
		  }
	  @BeforeClass
	  public void beforeClass() throws Exception {
			 response=RestAssured.given().contentType(prop.getProperty("content")).body(data.toString()).auth().basic(prop.getProperty("username"), prop.getProperty("password")).when().post("/create").then().log().all().extract().response();
			System.out.println(response.getBody().asString());
			System.out.println(response.getStatusCode());
		  
		  
	  }
	 
	  @BeforeMethod
	  public void beforeMethod() {
		  JsonPath js=response.jsonPath();
		  System.out.println("The data added succefully ==>"+js.get("message"));
		  System.out.println("the employee name is==>"+js.get("data.employee_name")); 
	  }
	 
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println(response.getStatusCode());
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println(response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");
		 
	  }
	  @AfterTest
	  public void afterTest() {
		 System.out.println("Response time is ===>"+response.getTime());
		 
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("The test is successfull and response body ===>"+response.getBody().asString());
		 
	  }

	 
	  }
	  
	  
	  
	  
	  
	  

