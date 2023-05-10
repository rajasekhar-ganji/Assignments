package api.com.apitesting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class RegularExpressions{
	public static Logger log = Logger.getLogger(RegularExpressions.class);
	
	@BeforeSuite
	public void GetResponseByUtils()
	{
		Utils.GetResponse();
	}
	
	@Test
	public void HamcrestAndregularExpressions() {
	Utils.InitialValidations();
	Utils.VerifyJsonpathObjects();
	}
	@AfterTest()
	public void UsingHamcrestMatchers()
	{
		Utils.ValidationsInJsonBody();
		log.info("******************the Test end**********************");
	}
	}
