package com.hailo.qa.testcases;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hailo.qa.base.TestBase;
import com.hailo.qa.pages.AdminPage;
import com.hailo.qa.pages.CustomersPage;
import com.hailo.qa.pages.Dashboard;
import com.hailo.qa.pages.LoginPage;
import com.hailo.qa.util.CustomListner;

@Listeners(CustomListner.class)
public class AdminTest extends TestBase {
	LoginPage loginPage;
	Dashboard dashboard;
	AdminPage admin;
	CustomersPage customers;
	
	private static Logger logger=Logger.getLogger(AdminTest.class.getName());

	@BeforeMethod
	public void setUp(Method method) throws InterruptedException {

//		if (!method.getName().equals("createNewStore")) {
			initialization();
			loginPage = new LoginPage();
			loginPage.loginWithAdmin(prop.getProperty("admin_email"), prop.getProperty("admin_password"));
			admin = new AdminPage();
			customers = new CustomersPage();
//		}else
			
//		{
//			driver = new ChromeDriver();
//			Thread.sleep(1000);
//		}

	}

	//@Test(priority = 1)
	public void toggleUserStatusTest() throws InterruptedException {
		
		logger.info("********Admin can Toggle user satus TC started*****************");
		logger.info("========Login with Admin User==============");
		dashboard = new Dashboard();
		Thread.sleep(1000);
		logger.info("========Navigate to Users page==============");
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		admin.navigateToUserPage();
		Thread.sleep(2000);
		List<WebElement> users=driver.findElements(By.xpath("//table[@id='usersid']//th[text()='USERNAME']/parent::tr/parent::thead/following-sibling::tbody//tr//td[2]"));
		int userCount=users.size();
		System.out.println("Total number of users: "+userCount);
		logger.info("========Navigate to Edit Users page==============");
		if(userCount>0) {
			admin.navigateToEditUserPage();
		}
		logger.info("========Change the status of the Users==============");
		admin.toggleStatusOfUser();
		Thread.sleep(2000);
		admin.clickOnupdateUserButton();
		Thread.sleep(2000);
		admin.verifyStatusAfterToggle();
		logger.info("********TC execution completed*****************");
	}
	@Test(priority=2)
	public void verifyResendEmailFunctionalityForCustomerStoresAndUsers() throws InterruptedException {
		logger.info("********Resend Email TC for Customer, Store Admin, User is started*****************");
		dashboard = new Dashboard();
		logger.info("==========Dashboard==========");
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.addCustomer();
		logger.info("==========Added a customer ==========");
		logger.info("==========Navigating to Edit customer page ==========");
		customers.navigateToEditCustomerPage();
		logger.info("==========Performing resend email action ==========");
		customers.checkResendEmailFeatureForAdminUser();
		customers.doPageRefresh();
		customers.addStore();
		logger.info("==========Added a store ==========");
		customers.addStoreUser();
		logger.info("==========Added a store user ==========");
		customers.checkResendEmailFeatureForStoreUser();
		logger.info("==========Resend email is done for store user ==========");
		customers.checkResendEmailFeatureForStoreAdmin();
		logger.info("==========Resend email is done for store Admin ==========");
		logger.info("********Resend Email TC for Customer, Store Admin, User is completed*****************");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
