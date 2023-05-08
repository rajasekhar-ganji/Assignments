package apiTestingPractice;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POM {
	Logger log=Logger.getLogger(POM.class);
	Properties prop = new Properties();
	public void ConnenctPropertyFile() {
		
		log.info("Start connent to property file");
		//Properties prop = new Properties();
		FileInputStream input = null;
		try {
			input = new FileInputStream(
					"C:\\Users\\rajasekhar.ganji\\eclipse-workspace\\APIHYd\\src\\test\\resources\\Properties.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("connected to property file successfully");
		RestAssured.baseURI = prop.getProperty("url");
		System.out.println(prop.getProperty("url"));
		log.info("the url is lsunch successfully");
	}
	public void GetJsonFileData() {
		log.info("Start read data from Json file");
		JSONParser json = new JSONParser();
		FileReader file = null;
			try {
				file = new FileReader(
						"C:\\Users\\rajasekhar.ganji\\eclipse-workspace\\APIHYd\\src\\test\\resources\\TestBody.json");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Object obj = null;
		try {
			obj = json.parse(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject data=(JSONObject)obj;
		data.get("employee_name");
		data.get("employee_salary");
		data.get("employee_age");
		data.get("profile_image");
		RestAssured.given().body(data.toJSONString());
		log.info("the data successfully read from json file");
		
	}
	public void GetResponse() {
		Properties prop = new Properties();
		FileInputStream input = null;
		try {
			input = new FileInputStream(
					"C:\\Users\\rajasekhar.ganji\\eclipse-workspace\\APIHYd\\src\\test\\resources\\Properties.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		RestAssured.baseURI = prop.getProperty("url");
		JSONParser json = new JSONParser();
		FileReader file = null;
			try {
				file = new FileReader(
						"C:\\Users\\rajasekhar.ganji\\eclipse-workspace\\APIHYd\\src\\test\\resources\\TestBody.json");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Object obj = null;
		try {
			obj = json.parse(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject data=(JSONObject)obj;
		data.get("employee_name");
		data.get("employee_salary");
		data.get("employee_age");
		data.get("profile_image");
		RestAssured.given().body(data.toJSONString());
		log.info("before sending the request");
		Response response = RestAssured.given().contentType(prop.getProperty("content")).body(data.toString()).auth()
				.basic(prop.getProperty("username"), prop.getProperty("password")).when().post("/create").then().log()
				.all().extract().response();
		log.info("get the response and response body print in console");
		System.out.println("the response Body==>"+response.getBody().asString());
		log.info("the response code print in console");
		System.out.println(response.getStatusCode());
		int responsecode=response.getStatusCode();
		if(responsecode==200) {
		log.info("the response code validation success");
		}
		else 
		{
		log.warn("response code is mismatch and test failed");
		Assert.assertEquals(responsecode,200);
		}
		System.out.println("the repsonse time===>" + response.getTime());
		log.info("the response time printed in console");
		System.out.println(response.getStatusLine());
		log.info("the statusline printed in console and also doing validation");
		if(response.getStatusLine().equals("HTTP/1.1 200 OK"))
		{
		
		log.info("the statusline validation success");
	}
		else
		{
			log.warn("the validation fail because mismatch");
			Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		}
}
	
}