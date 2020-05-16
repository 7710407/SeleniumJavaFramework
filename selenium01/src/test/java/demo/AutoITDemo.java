package test.java.demo;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {
	
	@Test
	public void test() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.tinyupload.com/");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

			WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) { return driver.findElement(By.name("uploaded_file")); }
			});
			
			if(element.isEnabled()) {
				System.out.println("Element found");
				element.click();
			}

		//driver.findElement(By.name("uploaded_file")).click();
		
//		Runtime.getRuntime().exec("D:\\projects\\selenium\\FileUploadScript.exe");
	//	Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}

}
