package restTests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;

public class DataDriven extends DataForTests {

	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost()
	{
//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "Albert";
//		data[0][1] = "Einstein";
//		data[0][2] = 2;
//		
//		data[1][0] = "Thomas";
//		data[1][1] = "Edison";
//		data[1][2] = 1;
//		
//		return data;
		
		return new Object[][]
				{
					{"Graham", "Bell",1},
					{"Henry", "Ford",2}
			
				};
		
	}
	
	//@Test(dataProvider = "DataForPost")
	public void test_post(String firstName, String lastName, int subjectId)
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
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
	
	@DataProvider(name = "DeleteData")
	public Object[] dataForDelete() 
	{
		return new Object[]
				{
						4,5,6
				};
	}
	
	
	@Parameters({"userId"})
	@Test(dataProvider = "DeleteData")
	public void test_delete(int userId)
	{
		baseURI = "http://localhost:3000";
		
		when().delete("/user/"+userId).
		then().statusCode(200);
	}
	
}
