package lambdaTest;

import org.testng.annotations.Test;

public class LambdappRegister extends Parent {
  PomFile file;
	
	
	@Test
  public void register() {
	 file=new PomFile(driver);
	 file.HoveronElement();
	 file.registerclick();
	 file.Enterdata("grajasekhar", "ganji", "ksekhar@gmail.com", "0401234", "1234567raa", "1234567raa");
	 file.clickinput();
	 file.presssubmit();
	 file.getSuccessmessage();
	 file.HoveronElement();
	 file.logoutbuttonpress();
	 file.getlogoutSuccessMessage();
	 file.HoveronElement();
	 file.loginpress();
	 file.loginCredentials("ksekhar@gmail.com", "1234567raa");
	 file.pressedloginbutton();
	 
	 
	 
  }
}
