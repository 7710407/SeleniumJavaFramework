package test.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo2 {

	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void listAmSearch() {
		driver.get("https://list.am");
		driver.findElement(By.name("q")).sendKeys("hello" + Keys.ENTER);
	}
	
	@Test
	public void listAmSearch2() {
		driver.get("https://list.am");
		driver.findElement(By.name("q")).sendKeys("hello" + Keys.ENTER);
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();		
	}
}
