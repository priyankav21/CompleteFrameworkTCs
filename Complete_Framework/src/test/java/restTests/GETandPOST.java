package restTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GETandPOST {

	//@Test
	public void GETtest(String baseurl)
	{
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").
			then().
		statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name",hasItems("George","Rachel"));
	}
	
	@Test
	public void POSTtest()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Rama");
//		map.put("job", "Intern");
//		
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Rama");
		request.put("job", "Intern");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON). //explicitly telling server the format sent is JSON
			accept(ContentType.JSON).      // telling response type taken is also of type JSON 
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}
}
