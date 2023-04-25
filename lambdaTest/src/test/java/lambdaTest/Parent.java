package lambdaTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Parent {
 WebDriver driver;
  @BeforeClass
		public void browserOpening() throws Exception {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://ecommerce-playground.lambdatest.io/");
		}
  @AfterClass
  public void afterClass() {
	 driver.close();
  }

}
