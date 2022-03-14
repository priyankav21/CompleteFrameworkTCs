package SeleniumWebDriverManager;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;


public class databaseTests 
{

	@Test(dataProvider="DP")
	public void validatePage(String uname, String pword)
	{
		System.out.println("DataBase Values: "+ uname);
		System.out.println("DataBase Values: "+ pword);
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get(url);
//		driver.findElement(By.id("")).sendKeys(uname);
//		driver.findElement(By.id("")).sendKeys(pword);
//		driver.findElement(By.id("")).click();
		
	}
	
	@DataProvider(name="DP")
	public String[][] feedDP() throws ClassNotFoundException, SQLException
	{
		String data[][] = getDBValues(Constant.url, Constant.username, Constant.password,"Select * from world.login" );
		return data;
	}
	
	public String[][] getDBValues(String url, String username, String password, String query) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		String url = "jdbc:mysql://localhost:3306/world";
//		String username = "root";
//		String password = "12345";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stml = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		int value = stml.executeUpdate("INSERT INTO `world`.`login` VALUES('zestie','zesty@123');");
		System.out.println("The rows are updated "+value);
		ResultSet rs = stml.executeQuery("Select * from world.login");
		rs.last();
		
		
		int rows = rs.getRow();
		System.out.println("Number of rows: "+rows);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		System.out.println("Number of columns: "+cols);
		
		String data[][] = new String[rows][cols];
		
		int i = 0;
		rs.beforeFirst();
		while(rs.next())
		{
			for(int j=0;j<cols;j++)
			{
				data[i][j] = rs.getString(j+1);
			}
			i++;
		}
		
		return data;
	}
	
}

