package test.java.demo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside test 1");
	}

	@Test
	public void test2() {
		System.out.println("I am inside test 2");
//		int i = 1/0;
	}

	@Test(retryAnalyzer = test.java.listeners.RetryAnalizer.class)
	public void test3() {
		System.out.println("I am inside test 3");
		Assert.assertTrue(false);
	}

}
