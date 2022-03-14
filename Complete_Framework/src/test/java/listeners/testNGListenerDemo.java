package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class testNGListenerDemo {

	@Test
	public void test1()
	{
		System.out.println("Inside test 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Inside test 2");
		//Assert.assertTrue(false);
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path: "+projectPath);
		
		//System.setProperty("webdriver.gecko.driver",projectPath+"\\Drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver",projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("zestmoney");
		driver.findElement(By.xpath("//input[@name='xyz']")).sendKeys("zestmoney");
		
		driver.close();
	}
	
	@Test
	public void test3()
	{
		System.out.println("Inside test 3");
		throw new SkipException("test skipped");
	}
}
