package Reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObj.GoogleSearchObj;

public class GoogleSearchTestObj {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearchTest();
	}
	
	public static void googleSearchTest()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver");
	    driver = new ChromeDriver();
	    
	    GoogleSearchObj searchPageObj = new GoogleSearchObj(driver);
	    
	    driver.get("https://google.com");
	    
	    searchPageObj.setTextInSearchBox("Buy now pay later");
	    
	    searchPageObj.clickSearchButton();
	    
	    driver.close();
	}
}
