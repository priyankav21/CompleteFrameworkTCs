package restTests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class post_get_methods {
	
	public Response APIconstantTest(String baseURI, String id)
	{
		RestAssured.baseURI=baseURI;
		Response res=(Response) RestAssured
				.given()
				.queryParam("id", id)
				.contentType(ContentType.JSON).log().all()
				.when()
				.get()
				.then()
				.statusCode(200)
				//.body("title", hasItem(Fields.LOCATION))
				.extract()
				.response();
		return res;
	}
	
	public void getAPI(String baseURI, String basePath, JSONObject requestPayload)
	{
        RestAssured.baseURI = baseURI;
		given().get("/users?page=2").then().
		statusCode(200);
	}
	
	public Response postAPI(String baseURI, String basePath, JSONObject requestPayload)
	{
		RestAssured.baseURI = baseURI;
		RestAssured.basePath = basePath;
		Response response = given().body("requestPayload").
				            log().all().when().post();
		return response;
	}
	
}
