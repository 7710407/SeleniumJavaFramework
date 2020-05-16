package main.java.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("Hello log4j");
		logger.trace("This is trace message");
		logger.info("This is info message");
		logger.error("This is an error message");
		logger.warn("This is a warn message");
		logger.fatal("This is a fatal message");
		
		System.out.println("Completed!");
	}
	

}
