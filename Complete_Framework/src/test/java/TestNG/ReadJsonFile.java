package TestNG;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFile {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		
		FileReader reader = new FileReader(".\\json_files\\TestData.json");
		
		Object obj = jsonparser.parse(reader);
		
		JSONObject testobj = (JSONObject)obj;
		
		String mail = (String)testobj.get("mail");
		String name = (String)testobj.get("name");
		
		System.out.println("Email: "+mail);
		System.out.println("First Name: "+name);
		
		JSONArray array=(JSONArray)testobj.get("data");
		
		for(int i=0;i<array.size();i++)
		{
			JSONObject data = (JSONObject) array.get(i);
			
			String email = (String)data.get("email");
			String first_name = (String)data.get("first_name");
			String last_name = (String)data.get("last_name");
			
			System.out.println(i+"\n"+email+"\n"+first_name+"\n"+last_name);
			
		}
		
		
	}

}
