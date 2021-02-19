package com.hailo.qa.testcases;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.google.common.base.Suppliers;
import com.hailo.qa.base.TestBase;
import com.hailo.qa.pages.Dashboard;
import com.hailo.qa.pages.LoginPage;
import com.hailo.qa.pages.SuppliersPage;
import com.hailo.qa.util.CustomListner;

@Listeners(CustomListner.class)
public class AddSupplierTest extends TestBase {
	LoginPage loginPage;
	Dashboard dashboard;
	SuppliersPage suppliersPage;
	private static Logger logger=Logger.getLogger(CustomersTest.class.getName());

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage.loginWithAdmin(prop.getProperty("admin_email"), prop.getProperty("admin_password"));
		suppliersPage = new SuppliersPage();
	}

	@Test(priority = 1)
	public void createNewSupplierTest() throws InterruptedException {
		dashboard = new Dashboard();
		dashboard.clickonAdminMenu();
		logger.info("*******************Add new supplier test executon started******************");
		suppliersPage.openAddSupplierWindow();
		Thread.sleep(2000);
		logger.info("==============Entering Supplier details===========");
		suppliersPage.enterSupplierName();
		suppliersPage.enterSupplierFirstName()	;
		suppliersPage.enterSupplierLastName();
		suppliersPage.enterEmail();
		suppliersPage.enterSupplierContact();
		Thread.sleep(2000);
		suppliersPage.enableStatus();
		Thread.sleep(2000);
		suppliersPage.enableCheckboxes();
		Thread.sleep(5000);
		suppliersPage.clickCreateAccountButton();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		suppliersPage.verifySupplierIsAdded();
		logger.info("==============Supplier is added successfully===========");
		logger.info("*******************Add new supplier test executon completed******************");
	}
		
//		@Test(priority = 2)
//		public void searchSupplier () throws InterruptedException{
//			logger.info("*******************Search supplier test executon started******************");
//			dashboard = new Dashboard();
//			dashboard.clickonAdminMenu();
//			suppliersPage.searchSupplier();
//			Thread.sleep(1000);	
//			logger.info("*******************Search supplier test executon completed******************");
//		}
//		@Test(priority = 3)
//		public void viewSupplierLocationTest () throws InterruptedException{
//			logger.info("*******************View supplier location test executon started******************");
//			dashboard = new Dashboard();
//			dashboard.clickonAdminMenu();
//			suppliersPage.viewSupplierLocation();
//			Thread.sleep(1000);	
//			logger.info("*******************View supplier test executon completed******************");
//		}
		
		@Test(priority=2)
		public void addNewSupplierLocationTest() throws InterruptedException, AWTException {
			logger.info("*******************Add supplier location test executon started******************");
			dashboard = new Dashboard();
			dashboard.clickonAdminMenu();
			suppliersPage.addSupplierLocation();
			logger.info("*******************Add supplier location test executon completed******************");
		}
		@Test(priority=3)
		public void editNewSupplierLocationTest() throws InterruptedException, AWTException {
			logger.info("*******************Edit supplier location test executon started******************");
			dashboard = new Dashboard();
			dashboard.clickonAdminMenu();
			suppliersPage.updateSupplierLocationDetails();;
			logger.info("*******************Edit supplier location test executon completed******************");
		}
		@Test(priority=4)
		public void deleteSupplierLocationTest() throws InterruptedException, AWTException {
			logger.info("*******************Delete supplier location test executon started******************");
			dashboard = new Dashboard();
			dashboard.clickonAdminMenu();
			suppliersPage.deleteSupplierLocation();
			logger.info("*******************Delete supplier location test executon completed******************");
		}	

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
