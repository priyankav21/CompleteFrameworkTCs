package restTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Example {
	//@Test
	public void test_get()
	{
		baseURI = "http://localhost:3000";
		
		given().
			param("name","Automation").
			get("/subjects").
		then().
			statusCode(200).log().all();
	}
	
	//@Test
	public void test_post()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Ana");
		request.put("lastName", "Smith");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/user").
		then().
			statusCode(201).
			log().all();
	}
	
	//@Test
	public void test_patch()
	{
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Yuna");
		
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			patch("/user/5").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void test_put()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Mary");
		request.put("lastName", "Jane");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			put("/user/5").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void test_delete()
	{
		baseURI = "http://localhost:3000";
		
		when().delete("/user/4").
		then().statusCode(200);
	}
}
