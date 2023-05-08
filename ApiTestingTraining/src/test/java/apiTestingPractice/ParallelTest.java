package apiTestingPractice;

import org.testng.annotations.Test;
public class ParallelTest {
	
	@Test()
	public void Connect_PropertiesFile() {
		Utils.ConnectPropertyFile();
	}
	
	@Test(dependsOnMethods="Connect_PropertiesFile")
	public void Read_JsonFile() {
		Utils.GetDataFromJSONFile();
	}
	@Test(dependsOnMethods="Read_JsonFile")
	public void APIRequest_getResponse() {
		Utils.GetResponseFor_APIRequest();
	}
	@Test(dependsOnMethods="APIRequest_getResponse")
	public void VerifyAllValidations() {
		Utils.VerifyValidations();
	}
		}
	

