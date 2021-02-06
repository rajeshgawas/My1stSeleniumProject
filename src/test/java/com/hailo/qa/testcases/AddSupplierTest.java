package com.hailo.qa.testcases;

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

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		suppliersPage = new SuppliersPage();
		// dashboard = new Dashboard();

	}

	@Test(priority = 1)
	public void createNewSupplier() throws InterruptedException {
		dashboard = new Dashboard();
		dashboard.clickonAdminMenu();
		suppliersPage.openAddSupplierWindow();
		Thread.sleep(2000);
		suppliersPage.enterSupplierName();
		suppliersPage.enterSupplierFirstName();
		suppliersPage.enterSupplierLastName();
		suppliersPage.enterEmail();
		suppliersPage.enterSupplierContact();
		Thread.sleep(2000);
		suppliersPage.enableStatus();
		Thread.sleep(500);
		suppliersPage.enableCheckboxes();
		suppliersPage.uploadDoc();
		Thread.sleep(5000);
		suppliersPage.clickCreateAccountButton();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
