package com.hailo.qa.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenerateLogs {
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger log = Logger.getLogger(GenerateLogs.class);		
		PropertyConfigurator.configure("C:\\Users\\rajesh.gawas\\eclipse-workspace\\com.hailo\\src\\main\\java\\syslogs\\log4j.properties");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajesh.gawas\\.cache\\selenium\\chromedriver\\win32\\88.0.4324.96\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.info("Launching browser");
		driver.get("http://www.google.com");
		log.info("Google url has been opened");
		String title = driver.getTitle();
		log.info("Title is:" + title);

		if (title.equals("Google")) {
			log.info("Correct title is Google and test case passed");
		} else {
			log.info("Title doesn't match and test case failed");
		}

		driver.quit();
	}

}
