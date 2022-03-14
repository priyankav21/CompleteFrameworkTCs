package SeleniumWebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyboardActions {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/*
		//sendkeys()
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
		*/
		
		/*
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
		
		Actions actionProvider = new Actions(driver);
		Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		keydown.perform();
		*/
		
		driver.get("https://google.com");
		Actions action = new Actions(driver);
		WebElement search = driver.findElement(By.name("q"));
		action.keyDown(Keys.SHIFT).sendKeys(search,"selenium")
		.keyUp(Keys.SHIFT).sendKeys(" selenium").perform();
		
		search.clear();
		
		driver.quit();
	}
}
