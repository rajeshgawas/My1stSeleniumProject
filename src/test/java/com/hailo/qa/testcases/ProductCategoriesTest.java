package com.hailo.qa.testcases;

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
import com.hailo.qa.pages.ProductCategoriesPage;
import com.hailo.qa.pages.SuppliersPage;
import com.hailo.qa.util.CustomListner;

@Listeners(CustomListner.class)
public class ProductCategoriesTest extends TestBase {
	LoginPage loginPage;
	Dashboard dashboard;
	ProductCategoriesPage productCat;
	
	private final Logger logger=Logger.getLogger(this.getClass().getName());

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("admin_email"), prop.getProperty("admin_password"));
		productCat= new ProductCategoriesPage();
	}

	//@Test(priority = 1)
	public void doSearchAndOpenProductCategory() throws InterruptedException {
		logger.info("***********Searching category test execution started*************");
		dashboard = new Dashboard();
		productCat.navigateToProductCategoriesPage();
		productCat.verifyAddNewProductCategoryPopUp();
		productCat.searchCategoryAndOpen();
		logger.info("***********Searching category test execution completed*************");
	}
	
	@Test(priority = 2)
	public void createNewSubcategory() throws InterruptedException {
		logger.info("***********Adding new subcategory test execution started*************");
		dashboard = new Dashboard();
		productCat.navigateToProductCategoriesPage();
		productCat.searchCategoryAndOpen();
		productCat.addNewSubcategory();
		logger.info("***********Adding new subcategory test execution completed*************");
	}
	@Test(priority = 3)
	public void viewSubcategory() throws InterruptedException {
		logger.info("***********View subcategory test execution started*************");
		dashboard = new Dashboard();
		productCat.navigateToProductCategoriesPage();
		productCat.searchCategoryAndOpen();
		productCat.viewSubCategory();
		logger.info("***********View subcategory test execution completed*************");
	}
	@Test(priority = 4)
	public void updateSubcategory() throws InterruptedException {
		logger.info("***********Edit subcategory test execution started*************");
		dashboard = new Dashboard();
		productCat.navigateToProductCategoriesPage();
		productCat.searchCategoryAndOpen();
		productCat.editSubCategory();
		logger.info("***********Edit subcategory test execution completed*************");
	}
	@Test(priority = 5)
	public void deleteSubcategory() throws InterruptedException {
		logger.info("***********Delete subcategory test execution started*************");
		dashboard = new Dashboard();
		productCat.navigateToProductCategoriesPage();
		productCat.searchCategoryAndOpen();
		productCat.deleteSubCategory();
		logger.info("***********Delete subcategory test execution completed*************");
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
