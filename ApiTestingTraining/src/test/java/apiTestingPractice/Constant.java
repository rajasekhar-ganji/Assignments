package apiTestingPractice;

public class Constant {
		
		public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	    public final static String propertyfile_path  = PROJECT_BASE_PATH + "/src/test/resources/Properties.properties";
	    public final static String jsonfile_path = PROJECT_BASE_PATH + "/src/test/resources/TestBody.json";
	    public final static String xmlfile_path=PROJECT_BASE_PATH+"/testng.xml";
	    public final static String post="/create";
	    public final static String get= "/employees";
	    public final static String getById= "/employee/20";
	    public final static String put= "/update/3";
	    public final static String delete="/employee/5";
	    public final static String statusline="HTTP/1.1 200 OK";
	    public final static int statuscode=200;
	    public final static int salary=500000;
	    public final static String method="Get";
	    public final static String employeename="Brielle Williamson";
	    public final static String employeehalfname="Williamson";
	    public final static String url="https://dummy.restapiexample.com/api/v1/employees";
	}


