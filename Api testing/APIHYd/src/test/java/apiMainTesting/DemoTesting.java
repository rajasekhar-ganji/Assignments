package apiMainTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoTesting {

	public void maintain() {
		String auth="Authentication";
		String AccessToken = "myaccesstoken";
		String ClientToken = "myclienttoken";
		String ClientSecret = "myclientsecret";
		String url = "https://dummy.restapiexample.com/api/v1";
		String contentType = "application/json";
			Object[] bearer= {auth, AccessToken, ClientToken, ClientSecret};

	}

}
