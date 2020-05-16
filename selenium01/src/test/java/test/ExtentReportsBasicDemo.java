package test.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {

	static WebDriver driver = null;
	
	public static void main(String[] args) {
		// directory where output is to be printed
		System.out.println(System.getProperty("user.dir"));
		ExtentSparkReporter spark = new ExtentSparkReporter("user/build/name/");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);

		ExtentTest test = extent.createTest("Google search test", "This is test to validate google search functionality.");
		test.pass("details");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test.log(Status.INFO, "Starting test case.");

		driver.get("http://google.com");
		test.pass("Navigated to google.com");
		driver.findElement(By.name("q")).sendKeys("king");
		test.pass("Entered text in Searchbox");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test.pass("Pressed keyboard enter key");

		test.pass("Closed the browser");
		driver.close();
		driver.quit();
		test.info("Test completed");
		
		ExtentTest test1 = extent.createTest("Google search test1", "This is test1 to validate google search functionality.");
		test1.pass("details");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting test case. 1");

		driver.get("http://google.com");
		test1.pass("Navigated to google.com");
		driver.findElement(By.name("q")).sendKeys("Artur king");
		test1.pass("Entered text in Searchbox 1");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test.fail("Pressed keyboard enter key");

		driver.close();
		driver.quit();
		test1.pass("Closed the browser 1");
		
		test1.info("Test 1 completed");

		extent.flush();
	}

}
