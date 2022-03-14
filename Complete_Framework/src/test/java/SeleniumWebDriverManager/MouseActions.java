package SeleniumWebDriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		WebElement boxA = driver.findElement(By.xpath("//li[text()='A']"));
		WebElement boxC = driver.findElement(By.xpath("//li[text()='C']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(boxA);
		actions.clickAndHold();
		actions.moveToElement(boxC);
		actions.release().perform();
		//actions.contextClick(boxC);
		//actions.doubleClick(boxD);
		
		driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
		WebElement elem1 = driver.findElement(By.id("draggable"));
		WebElement elem2 = driver.findElement(By.id("draggable"));
		
		actions.dragAndDrop(elem1, elem2);
		actions.build().perform();
		
		
		driver.quit();
		System.out.println("Completed");
	}
}
