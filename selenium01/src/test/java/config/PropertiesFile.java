package test.java.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.java.test.TestNG_Demo;

public class PropertiesFile {

	static Properties properties = new Properties();
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();
	}

	public static void getProperties() {
		try {
			InputStream input = new FileInputStream(projectPath + "\\src\\test\\java\\config\\config.properties");
			properties.load(input);
			String browser = properties.getProperty("browser");
			System.out.println(browser);
			TestNG_Demo.browserName = browser;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath + "\\src\\test\\java\\config\\config.properties");
			properties.setProperty("result", "pass");
			properties.store(output, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}
