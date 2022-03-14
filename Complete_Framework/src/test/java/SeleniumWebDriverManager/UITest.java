package SeleniumWebDriverManager;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Constants.ProjConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UITest {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
		
	}
	
	@Test(dataProvider = ProjConstants.dPro)
	void login(String data)
	{
		String users[] = data.split(",");
		driver.get(ProjConstants.BASEPATH);
		driver.findElement(By.id("Email")).sendKeys(users[0]); //gives username
		driver.findElement(By.id("Password")).sendKeys(users[1]); //gives password
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		String act_title = driver.getTitle();
		String exp_title = ProjConstants.eTitle;
		Assert.assertEquals(act_title, exp_title);
		
	}
	
	@DataProvider(name=ProjConstants.dPro)
	public String[] readJson() throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\json_files\\DDtest.json");
		
		Object obj=jsonParser.parse(reader);
		
		JSONObject userloginsJsonobj = (JSONObject)obj;
		JSONArray userloginArray = (JSONArray) userloginsJsonobj.get("userlogins");
		
		String arr[] = new String[userloginArray.size()];
		
		for(int i=0;i<userloginArray.size();i++)
		{
			 JSONObject users = (JSONObject) userloginArray.get(i);
			 String user = (String) users.get("username");
			 String pwd = (String) users.get("password");
			 
			 arr[i] = user+","+pwd;
			 
		}
		
		return arr;
	}
}
