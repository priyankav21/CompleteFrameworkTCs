package TestNG;

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

import Constants.Constant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Execute {

	WebDriver driver;
	int count =0;
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	@Test(dataProvider=Constant.DATA)
	void login(String data) throws InterruptedException
	{
		count=count+1;
		String users[] = data.split(",");
		driver.get(Constant.BASEPATH);
		driver.findElement(By.id("txtUsername")).sendKeys(users[0]);
		driver.findElement(By.id("txtPassword")).sendKeys(users[1]);
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		String act_url=driver.getCurrentUrl();
		//Assert.assertEquals(act_url, Constant.EXP_URL);
		if(Constant.EXP_URL.equals(act_url))
		{
			System.out.println("Correct "+users[0]+" "+" "+users[1]);
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("INCorrect "+users[0]+" "+" "+users[1]);
			Assert.assertFalse(false);
		}
		
	}
	
	@DataProvider(name=Constant.DATA)
	public String[] readJson() throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\TestData\\TestData.json");
		
		Object obj = jsonParser.parse(reader);
		
		JSONObject jsonlogin = (JSONObject)obj;
		JSONArray  arraylogin = (JSONArray) jsonlogin.get("Credential");
		
		String arr[] = new String[arraylogin.size()];
		
		for(int i=0;i<arraylogin.size();i++)
		{
			JSONObject users = (JSONObject) arraylogin.get(i);
			String user = (String) users.get("UserId");
			String pass = (String) users.get("pass");
			
			arr[i] = user+","+pass;
		}
		return arr;
	}
}
