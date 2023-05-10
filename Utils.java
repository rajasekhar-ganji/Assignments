package api.com.apitesting;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import apiTestingPractice.Constant;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	public static Response response;
	public static JsonPath jsonpath;
	public static ArrayList<Object> list;
	public static Logger log = Logger.getLogger(Utils.class);
  public static void GetResponse () {
	  log.info("*************The test started************");
		response = RestAssured.get(Constant.url);
		log.info("the url opened and send request and get the response successfully ");
		System.out.println(response.getBody().asString());
		log.info("the response body printed in console");
  }
  public static void InitialValidations()
  {
	  String responsebody = response.getBody().asString();
		if(response.getStatusCode()==Constant.statuscode) {
			log.info("The validation of statuscode success");
		}
		else {
			log.warn("<=====the validation of statuscode failed=====>");
		assertThat(response.getStatusCode(), is(Constant.statuscode));
		}
		if(response.getStatusLine().equals(Constant.statusline)) {
			log.info("The validation of statusline success");
		}
		else {
			log.warn("<=====the validation of statusline failed====>");
	   assertThat( response.getStatusLine(), equalTo(Constant.statusline));
		}
		log.info("The validation with regular expression");
		boolean isMatch = responsebody.matches(".*" + Constant.employeename + ".*");
		if(isMatch==true)
		{
			log.info("the employee name matched");
		}
		else {
			log.warn("<====the employee name mismatched====>");
		Assert.assertTrue(isMatch);
		}
  }
  public static void VerifyJsonpathObjects()
  {
	  log.info("Create the json path");
		jsonpath = response.jsonPath();
		log.info("ArrayList create for store objects");
	 list = jsonpath.get("data.id");
		log.info("The Total number of employees print in console");
		System.out.println("Total number of employees==>" + list.size());
  }
  
  public static void ValidationsInJsonBody()
  {
	  String empName = Constant.employeename;
		for (int i = 0; i < list.size(); i++) {
			if ((jsonpath.get("data.employee_name[" + i + "]")).equals(empName)) {
				assertThat(jsonpath.get("data.employee_name[" + i + "]").toString(), endsWith(Constant.employeehalfname));
				System.out.println("the name of employee is ===>" + jsonpath.get("data.employee_name[" + i + "]"));
				int actualValue=jsonpath.get("data.employee_salary[" + i + "]");
				int expectedValue=Constant.salary;
				MatcherAssert.assertThat(actualValue, Matchers.lessThan(expectedValue));
				log.info("<===the validation of salary is success===>");
				System.out.println("Salary of employee==>" + jsonpath.get("data.employee_salary[" + i + "]"));
				log.info("validate the employee age===>"+jsonpath.get("data.employee_age[" + i + "]").hashCode());
				if((jsonpath.get("data.employee_age[" + i + "]")).hashCode()>18) {
					log.info("employee age greaterThan 18 years");
				}
				else {
					log.warn("<==employee age under 18 years==>");
				assertThat(jsonpath.get("data.employee_age[" + i + "]").hashCode(), greaterThan(18));
				}
				System.out.println("the age validation  succesful");
				
				System.out.println("the employee age ==>" + jsonpath.get("data.employee_age[" + i + "]"));
				System.out.println("Id of employee==>" + jsonpath.get("data.id[" + i + "]"));
				
			}
		}
  
  
  
  
  }
}
