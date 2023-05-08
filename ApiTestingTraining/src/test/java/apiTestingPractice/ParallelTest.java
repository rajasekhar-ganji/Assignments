package apiTestingPractice;

import org.testng.annotations.Test;
public class ParallelTest extends POM {
	@Test(priority=1)
	public void Test1() {
		POM p=new POM();
		p.ConnenctPropertyFile();
	}
	@Test(priority=2)
	public void Test2() {
		POM p=new POM();
		p.GetJsonFileData();
	}
	@Test(priority=3)
	public void Test3() {
		POM p=new POM();
		p.GetResponse();
	}
	
		}
	

