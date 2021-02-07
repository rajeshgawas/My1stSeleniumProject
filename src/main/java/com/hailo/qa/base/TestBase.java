package com.hailo.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;

import com.hailo.qa.util.TakeScreenshot;
import com.hailo.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	private static Logger logger=Logger.getLogger(TestBase.class.getName());
	String timeStamp="";

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					// "C:/Users/rajesh.gawas/eclipse-workspace/com.hailo/src/main/java/config.properties");
					System.getProperty("user.dir") + "/src/main/java/config.properties");
			try {
				prop.load(ip);
				PropertyConfigurator.configure("Log4j.properties");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// Added for taking screenshots
	public void failed(String testMethodName) {
		Date date = new Date();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String file_name=System.getProperty("user.dir")+"/My_Screenshots/"+testMethodName+"_failed_"+timeStamp+".jpg";
		try {
			FileUtils.copyFile(srcFile, new File(file_name));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments(
					"user-data-dir=C:\\Users\\rajesh.gawas\\AppData\\Local\\Google\\Chrome\\User Data\\Guest Profile");
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments(
					"user-data-dir=C:\\Users\\rajesh.gawas\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\o98lusvh.FFselenium");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
//		driver.get(prop.getProperty("PAGE_LOAD_TIMEOUT"));
//		driver.get(prop.getProperty("IMPLICIT_WAIT"));
	}
//	public String onTestFailure(WebDriver driver, ITestResult result) throws IOException {
//		logger.info("***** Error :: " + result.getName() + " test has failed *****");
////		String testClassName = getTestClassName(result.getInstanceName()).trim();
//		String path = System.getProperty("user.dir") + prop.getProperty("screenshot_path");
////		createScreenshotFolder(testClassName);
//		String testMethodName = result.getName().toString().trim();
//		String screenShotName = testMethodName + ".png";
//		String screenshot_path = path +"/"+ screenShotName;
//		if (driver != null) {
//			CaptureScreenShot(driver, screenshot_path);
//		}
//		return screenshot_path;
//	}
//	private void CaptureScreenShot(WebDriver driver, String screenshot_path) {
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File source = screenshot.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(source, new File(screenshot_path));
//			logger.info("Screenshot is taken");
//		} catch (Exception e) {
//			System.out.println("Exception While taking Screenshot" + e.getMessage());
//		}
//	}
	

}
