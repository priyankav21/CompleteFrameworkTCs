package Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObj.GoogleSearchPage;

public class GoogleSearchTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver");
	    driver = new ChromeDriver();
		
		//goto google.com
		driver.get("https://google.com");
		
		//enter text in search textbox
		//driver.findElement(By.name("q")).sendKeys("Page Object Model");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("ZestMoney");
		
		//click on search button
	    //driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
		
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		//close browser
		driver.close();
		
		System.out.println("Test Completed Successfully");
		
		
	    
	}
}
