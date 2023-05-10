package apiTestingPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Utils {
	//static Logger log = Logger.getLogger(Utils.class);
	public static Logger log = Logger.getLogger(Utils.class);
	public static Properties prop;
	public static JSONObject passingdata;
	public static Response response;
//Connect_PropertiesFile Test
	public static void ConnectPropertyFile() {
		prop = new Properties();
		log.info("Start connect to property file");
		FileInputStream input = null;
		try {
			input = new FileInputStream(Constant.propertyfile_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("connected to property file successfully");
		String url=prop.getProperty("url");
		if(!url.equals(null)) {
			System.out.println(prop.getProperty("url"));
			log.info("the url is launch successfully");
			RestAssured.baseURI = prop.getProperty("url");
		}
		else
		{
			System.out.println("No url found");
			log.warn("the url is launch failed");
		}
	}
                           
//Read_JsonFile Test
	public static void GetDataFromJSONFile() {
		log.info("Start read data from Json file");
		JSONParser json = new JSONParser();
		FileReader file = null;
		try {
			file = new FileReader(Constant.jsonfile_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object jsondata = null;
		try {
			jsondata = json.parse(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passingdata = (JSONObject) jsondata;
		RestAssured.given().body(passingdata.toJSONString());
		log.info("the data successfully read from json file");
	}
	
	public static void GetResponseFor_APIRequest() {
		String method = Constant.method;
		//POST_Response Test
	    if (method.equals("Post")) {
	    	System.out.print("The POST Request Running");
		log.info("before sending the request");
		response = RestAssured.given().contentType(prop.getProperty("content")).body(passingdata.toString()).auth()
				.basic(prop.getProperty("username"), prop.getProperty("password")).when().post(Constant.post).then().log()
				.all().extract().response();
		log.info("the post response recieved");
		
	    }
//GET_Response Test
	    else if(method.equals("Get")){
		log.info("before sending the request");
		response = RestAssured.given().contentType(prop.getProperty("content")).body(passingdata.toString()).auth()
				.basic(prop.getProperty("username"), prop.getProperty("password")).when().get(Constant.get).then().log()
				.all().extract().response();
		log.info("the get response recieved");
	}
	//GETById_Request Test
	    else if (method.equals("GetById")) {
			log.info("before sending the request");
			response = RestAssured.given().contentType(prop.getProperty("content")).body(passingdata.toString()).auth()
					.basic(prop.getProperty("username"), prop.getProperty("password")).when().get(Constant.getById).then().log()
					.all().extract().response();
			log.info("the getbyid response recieved");
		}
//Put_Request Test
		 else if (method.equals("Put")){
		    	System.out.print("The Put Request Running");
			log.info("before sending the request");
			response = RestAssured.given().contentType(prop.getProperty("content")).body(passingdata.toString()).auth()
					.basic(prop.getProperty("username"), prop.getProperty("password")).when().put(Constant.put).then().log()
					.all().extract().response();
			log.info("the getbyid response recieved");
		 }
			 else {
				 System.out.println("NO TEST IS RUNNING NOW");
			 }
		 }
		
	
	
//VerifyAllValidations Test
	public static void VerifyValidations() {
		log.info("get the response and response body print in console");
		System.out.println("the response Body==>" + response.getBody().asString());
		log.info("the response code print in console");
		System.out.println(response.getStatusCode());
		int expectedcode = Constant.statuscode;
		int actualcode = response.getStatusCode();
		boolean validation = (actualcode == expectedcode);
		if (validation == true) {
			log.info("the response code validation success");
		} else {
			log.warn("response code is mismatch and test failed");
			Assert.assertEquals(actualcode, expectedcode, "mismatch of response codes occurs");
		}
		System.out.println("the repsonse time===>" + response.getTime());
		log.info("the response time printed in console");
		System.out.println(response.getStatusLine());
		log.info("the statusline printed in console and also doing validation");
		String actualstatusline = response.getStatusLine();
		String expectedstatusline = Constant.statusline;
		boolean validate = (actualstatusline.equals(expectedstatusline));
		if (validate == true) {
			log.info("the statusline validation success");
		} else {
			log.warn("the validation fail because mismatch");
			Assert.assertEquals(actualstatusline, expectedstatusline, "mismatch of status line occurs");
		}
	
	}
}
