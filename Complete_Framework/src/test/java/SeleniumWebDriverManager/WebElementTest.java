package SeleniumWebDriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/*
		// to find elements
		driver.get("https://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium"+ Keys.ENTER);
		//driver.findElement(By.name("btnK")).click();
		*/
		
		/*
		// to find elements
		driver.get("https://trytestingthis.netlify.app/");
		List<WebElement> elements = driver.findElements(By.tagName("select"));
		
		for(WebElement element:elements)
		{
			System.out.println(element.getText());
		}
		*/
		
		/*
		//to find element within element
		driver.get("http://www.google.com");
		WebElement searchForm = driver.findElement(By.tagName("form"));
		WebElement searchBox = searchForm.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		*/
		
		/*
		//get active element
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		String title = driver.switchTo().activeElement().getAttribute("title");
		System.out.println(title);
		*/
		
		/*
		//get tagname, text, css...
		driver.get("https://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		String tagname = searchBox.getTagName();
		String text = searchBox.getText();
		String cssValue = searchBox.getCssValue("font");
		
		System.out.println(tagname+"|"+text+"|"+cssValue);
		*/
		
		//to check element is enabled is selected
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		System.out.println(checkbox.isEnabled());
		System.out.println(checkbox.isSelected());

		
		driver.quit();
	}
}
