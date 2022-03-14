package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Constants.ProjConstants;

public class TestNGParallelTesting {

	WebDriver driver=null;
	
	@Test
	public void test1() throws Exception
	{
		System.out.println("TestNG test 1 |" + Thread.currentThread().getId());
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+ProjConstants.proPath);
		driver = new ChromeDriver();
		driver.get(ProjConstants.Google);
		Thread.sleep(ProjConstants.Stime);
		System.out.println(ProjConstants.TestSuccess);
		driver.close();
		
	}
	
	
	@Test
	public void test2() throws Exception
	{
		System.out.println("TestNG test 2 |" + Thread.currentThread().getId());
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+ProjConstants.proPath);
		driver = new ChromeDriver();
		driver.get(ProjConstants.Selenium);
		Thread.sleep(ProjConstants.Stime);
		System.out.println(ProjConstants.TestSuccess);
		driver.close();
	}
	
	@Test(threadPoolSize=3, invocationCount=3, timeOut=1000)
	public void test3() 
	{
		System.out.println("TestNG test 3 |" + Thread.currentThread().getId());
		
	}
	
	@Test
	public void test4()
	{
		System.out.println("TestNG test 4 |" + Thread.currentThread().getId());
		
		
	}
}
