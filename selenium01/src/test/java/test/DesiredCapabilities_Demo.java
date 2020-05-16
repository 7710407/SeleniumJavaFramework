package test.java.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.iedriver().setup();
//		WebDriverManager.chromedriver().setup();
		InternetExplorerOptions opts = new InternetExplorerOptions();
		opts.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriver driver = new InternetExplorerDriver(opts);
//		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));        
		WebElement element = wait.until(presenceOfElementLocated(By.name("q")));
//		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("h" + Keys.ENTER);
		//element.sendKeys(Keys.ENTER);
		
		driver.close();
		driver.quit();
	}

}
