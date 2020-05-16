package test.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.java.config.PropertiesFile;

public class TestNG_Demo {

	WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setUpTest() {
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
	}

	@Test
	public void googleSearch() {
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("hello" + Keys.ENTER);
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		PropertiesFile.setProperties();
		//driver.quit();		
	}
}
