package com.hailo.qa.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hailo.qa.base.TestBase;
import com.hailo.qa.pages.CustomersPage;
import com.hailo.qa.pages.Dashboard;
import com.hailo.qa.pages.LoginPage;
import com.hailo.qa.util.CustomListner;

@Listeners(CustomListner.class)
public class CustomersTest extends TestBase {
	LoginPage loginPage;
	Dashboard dashboard;
	CustomersPage customers;

	@BeforeMethod
	public void setUp(Method method) throws InterruptedException {

//		if (!method.getName().equals("createNewStore")) {
			initialization();
			loginPage = new LoginPage();
			loginPage.loginWithAdmin(prop.getProperty("admin_email"), prop.getProperty("admin_password"));
			customers = new CustomersPage();
//		}else
			
//		{
//			driver = new ChromeDriver();
//			Thread.sleep(1000);
//		}

	}

	@Test(priority = 1)
	public void createNewStore() throws InterruptedException {
		dashboard = new Dashboard();
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.addStore();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void checkEmail() throws InterruptedException {
//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
//		driver.findElement(By.linkText("https://www.mailinator.com/")).sendKeys(selectLinkOpeninNewTab);

		driver.get("https://www.mailinator.com/");
		customers.checkEmail();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
