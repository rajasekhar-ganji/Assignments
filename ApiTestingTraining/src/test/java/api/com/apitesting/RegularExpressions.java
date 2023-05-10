package api.com.apitesting;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import apiTestingPractice.Constant;
import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.junit.Assert;

public class RegularExpressions{
	@Test
	public void HamcrestAndregularExpressions() {
		Response response = RestAssured.get(Constant.url);
		System.out.println(response.getBody().asString());
		String responsebody = response.getBody().asString();
		assertThat(response.getStatusCode(), is(200));
	   assertThat( response.getStatusLine(), equalTo(Constant.statusline));
		boolean isMatch = responsebody.matches(".*" + Constant.employeename + ".*");
		Assert.assertTrue(isMatch);
		JsonPath js = response.jsonPath();
		ArrayList<Object> list = js.get("data.id");
		System.out.println("Total number of employees==>" + list.size());
		String Name = Constant.employeename;
		for (int i = 0; i < list.size(); i++) {
			if ((js.get("data.employee_name[" + i + "]")).equals(Name)) {
				System.out.println("the name of employee is ===>" + js.get("data.employee_name[" + i + "]"));
				System.out.println("Salary of employee==>" + js.get("data.employee_salary[" + i + "]"));
				assertThat(js.get("data.employee_age[" + i + "]").toString(), greaterThan("18"));
				System.out.println("the validation  succesful");
				System.out.println("the employee age ==>" + js.get("data.employee_age[" + i + "]"));
				System.out.println("Id of employee==>" + js.get("data.id[" + i + "]"));
			}
			else
				System.out.println("the employee data not found");
		}
	}
}
