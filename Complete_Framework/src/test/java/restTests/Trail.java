package restTests;

import org.testng.annotations.Test;



import io.restassured.response.Response;

public class Trail {
	post_get_methods p=new post_get_methods();

	@Test
	public void verified()
	{
		Response res = p.APIconstantTest("https://reqres.in/api/users","3");
		System.out.println(res.jsonPath().prettyPrint());
	}
}