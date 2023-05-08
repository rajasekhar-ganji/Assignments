package apiTestingPractice;

import java.util.ArrayList;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestNGRunner {
  @Test
  public void Test() {
	  
	  TestNG runner=new TestNG();
	  ArrayList<String> list=new ArrayList<String>();
	  list.add("C:\\Users\\rajasekhar.ganji\\eclipse-workspace\\APIHYd\\testng.xml");
	  runner.setTestSuites(list);
	  runner.run();
  }
}
