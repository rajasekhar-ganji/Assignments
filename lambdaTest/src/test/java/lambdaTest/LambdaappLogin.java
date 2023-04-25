package lambdaTest;

import java.util.Properties;
import java.io.FileInputStream;

import org.testng.annotations.Test;

public class LambdaappLogin extends Parent{
  @Test
  public void login() throws Exception {
	  
	Properties prop=new Properties();
	FileInputStream input=new FileInputStream("C:\\Users\\rajasekhar.ganji\\eclipse-workspace\\lambdaTest\\Properties.properties");
	prop.load(input);
	  PomFile file=new PomFile(driver);
	  file.HoveronElement();
	  file.loginpress();
	  file.loginCredentials(prop.getProperty("username"),prop.getProperty("userpwd"));
	  file.pressedloginbutton();
	  file.getloginSuccessMessage();
	  
	 
  }
}
