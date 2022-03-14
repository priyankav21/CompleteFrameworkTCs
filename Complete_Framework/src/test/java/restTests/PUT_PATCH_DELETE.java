package restTests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PUT_PATCH_DELETE {

	public Response APIconstantTest(String baseURI, String basePath, String ContentType, JSONObject requestPayload)
	{
		RestAssured.baseURI = baseURI;
		RestAssured.basePath = basePath;
		Response response = given().contentType("application/json").body("requestPayload").
				            log().all().when().post();
		return response;
	}
	
	@Test
	public void PUTtest()
	{
		
	Map<String, Object> map = new HashMap<String, Object>();
	
	
	JSONObject request = new JSONObject();
	
	
	baseURI = "https://reqres.in/api";
	
	request.put("name", "Rama");
	request.put("job", "Intern");
	
	System.out.println(request.toJSONString());
	
	given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON). //explicitly telling server the format sent is JSON
		accept(ContentType.JSON).      // telling response type taken is also of type JSON 
		body(request.toJSONString()).
	when().
		put("/users/2").
	then().
		statusCode(200).log().all();
}
	
	public void PATCHtest()
	{
	Map<String, Object> map = new HashMap<String, Object>();
	
	
	JSONObject request = new JSONObject();
	
	request.put("name", "Rama");
	request.put("job", "Intern");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in";
	
	given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON). //explicitly telling server the format sent is JSON
		accept(ContentType.JSON).      // telling response type taken is also of type JSON 
		body(request.toJSONString()).
	when().
		patch("/api/users/2").
	then().
		statusCode(200).log().all();
}
	
	public void DELETEtest()
	{
	
	baseURI = "https://reqres.in";
	
	when().
		delete("/api/users/2").
	then().
		statusCode(204).log().all();
}
}
