package apiTestingPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class ParallelTest {
	
	@BeforeSuite
	public void Connect_PropertiesFile() {
		Utils.ConnectPropertyFile();
	}
	
	@Test()
	public void Read_JsonFile() {
		Utils.GetDataFromJSONFile();
	}
	@Test(dependsOnMethods="Read_JsonFile")
	public void APIRequest_getResponse() {
		Utils.GetResponseFor_APIRequest();
	}
	@AfterTest()
	public void VerifyAllValidations() {
		Utils.VerifyValidations();
	}
		}
	

