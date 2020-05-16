package test.java.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {

	static WebDriver driver = null;
	ExtentReports extent = null;

	@BeforeSuite
	public void setUp() {
		ExtentSparkReporter spark = new ExtentSparkReporter("user/build/name/");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void test1() {
		ExtentTest test = extent.createTest("Google search test", "This is test to validate google search functionality.");
		driver.get("http://google.com");
		test.pass("Navigated to google.com");
		test.pass("details");
		test.log(Status.INFO, "Starting test case.");
		test.pass("Closed the browser");
		test.info("Test completed");
	}

	@Test
	public void test2() {
		ExtentTest test = extent.createTest("Google search test", "This is test to validate google search functionality.");
		driver.get("http://google.com");
		test.pass("Navigated to google.com");
		test.pass("details");
		test.log(Status.INFO, "Starting test case.");
		test.fatal("Closed the browser");
		test.info("Test completed");
	}

	@Test
	public void test3() {
		ExtentTest test = extent.createTest("Google search test", "This is test to validate google search functionality.");
		test.pass("details");
		test.log(Status.INFO, "Starting test case.");
		test.pass("Closed the browser");
		test.info("Test completed");

		//		driver.get("http://google.com");
		//		test.pass("Navigated to google.com");
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();		
	}

	//	public static void main(String[] args) {
	//		// directory where output is to be printed
	//
	//		
	//		driver.findElement(By.name("q")).sendKeys("king");
	//		test.pass("Entered text in Searchbox");
	//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	//		test.pass("Pressed keyboard enter key");
	//
	//		
	//		ExtentTest test1 = extent.createTest("Google search test1", "This is test1 to validate google search functionality.");
	//		test1.pass("details");
	//		WebDriverManager.chromedriver().setup();
	//		driver = new ChromeDriver();
	//		
	//		test1.log(Status.INFO, "Starting test case. 1");
	//
	//		driver.get("http://google.com");
	//		test1.pass("Navigated to google.com");
	//		driver.findElement(By.name("q")).sendKeys("Artur king");
	//		test1.pass("Entered text in Searchbox 1");
	//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	//		test.fail("Pressed keyboard enter key");
	//
	//		driver.close();
	//		driver.quit();
	//		test1.pass("Closed the browser 1");
	//		
	//		test1.info("Test 1 completed");
	//
	//	}

}
