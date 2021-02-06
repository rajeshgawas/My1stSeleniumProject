package com.hailo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hailo.qa.base.TestBase;
import com.hailo.qa.pages.Dashboard;
import com.hailo.qa.pages.LoginPage;
import com.hailo.qa.util.CustomListner;

@Listeners(CustomListner.class)
public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	Dashboard dashboard;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		SoftAssert softAssertion1 = new SoftAssert();
		String title = loginPage.validateLoginPageTitle();
		softAssertion1.assertEquals(title, "Hailo Web Portal");
		softAssertion1.assertAll();
		System.out.println("Title matches!");
	}

	@Test(priority = 2)
	public void loginPageLogoTest() {
		SoftAssert softAssertion2 = new SoftAssert();
		boolean flag = loginPage.validateLogo();
		softAssertion2.assertTrue(flag);
		softAssertion2.assertAll();
		System.out.println("Logo validated!");
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		dashboard = loginPage.login(prop.getProperty("admin_email"), prop.getProperty("admin_password"));
		boolean expectedLabel = dashboard.ValidateLogo();
//		Assert.assertSame(true, expectedLabel);
		Assert.assertEquals(true, expectedLabel);
		System.out.println("User logged in successfully!");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
