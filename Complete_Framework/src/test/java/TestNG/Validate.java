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
import io.github.bonigarcia.wdm.WebDriverManager;

public class Validate {
WebDriver driver;

@BeforeClass
void setup()
{
	System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com");
}

@AfterClass
void teardown()
{
	driver.close();
}

@Test(dataProvider="data1")
void login(String data)
{
	
	String users[] = data.split(",");
	
	
	driver.findElement(By.id("txtUsername")).sendKeys(users[0]); //gives username
	driver.findElement(By.id("txtPassword")).sendKeys(users[1]); //gives password
	driver.findElement(By.id("btnLogin")).click();
	
	String act_url = driver.getCurrentUrl();
	String exp_url = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	Assert.assertEquals(act_url, exp_url);
}

@DataProvider(name="data1")
public String[] readJson() throws IOException, ParseException, org.json.simple.parser.ParseException
{
	JSONParser jsonParser = new JSONParser();
	FileReader reader = new FileReader(".//src/test/resources//TestData.json");
	
	Object obj=jsonParser.parse(reader);
	
	JSONObject userloginsJsonobj = (JSONObject)obj;
	JSONArray userloginArray = (JSONArray) userloginsJsonobj.get("Credential");
	
	String arr[] = new String[userloginArray.size()];
	
	for(int i=0;i<userloginArray.size();i++)
	{
		 JSONObject users = (JSONObject) userloginArray.get(i);
		 String user = (String) users.get("UserId");
		 String pwd = (String) users.get("pass");
		 
		 arr[i] = user+","+pwd;
		 
	}
	
	return arr;
}
}
