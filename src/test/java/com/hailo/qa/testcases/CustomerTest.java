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
import com.hailo.qa.pages.CustomerPage;
import com.hailo.qa.pages.CustomersPage;
import com.hailo.qa.pages.Dashboard;
import com.hailo.qa.pages.LoginPage;
import com.hailo.qa.util.CustomListner;

@Listeners(CustomListner.class)
public class CustomerTest extends TestBase {
	LoginPage loginPage;
	Dashboard dashboard;
	CustomerPage customer;
	CustomersPage customers;

	private static Logger logger = Logger.getLogger(CustomerTest.class.getName());

	@BeforeMethod
	public void setUp(Method method) throws InterruptedException {

//		if (!method.getName().equals("createNewStore")) {
		initialization();
		loginPage = new LoginPage();
		loginPage.loginWithCustomer(prop.getProperty("customer_email"), prop.getProperty("customer_password"));
		customer = new CustomerPage();
		customers = new CustomersPage();
//		}else

//		{
//			driver = new ChromeDriver();
//			Thread.sleep(1000);
//		}

	}

	@Test(priority = 2) public void toggleUserStatusTest() throws
	  InterruptedException {
	  
	  logger.
	  info("********Customer can Toggle store satus TC started*****************");
	  logger.info("========Login with Customer User=============="); dashboard =
	  new Dashboard(); Thread.sleep(2000);
	  //button[@class='is-active dropdown-btn	  nav-link']/span[text()='My Store']);
	  logger.info("========Navigate to Store page==============");
	  customer.navigateToStorePage(); Thread.sleep(1000);
	  //customer.navigateToEditStorePage(); Thread.sleep(2000); 
	  List<WebElement> stores=driver.findElements(By. xpath("//table[@id='example']//th[text()='STORE NAME']/parent::tr/parent::thead/following-sibling::tbody//tr//td[2]")); 
	  int storeCount=stores.size();
	  System.out.println("Total number of users: "+storeCount);
	  logger.info("========Navigate to Edit Store page==============");
	  if(storeCount>0) { customer.navigateToEditStorePage();; }
	  logger.info("========Change the status of the Store==============");
	  customer.toggleStatusOfStore(); Thread.sleep(2000);
	  customer.clickOnupdateStoreButton(); Thread.sleep(2000);
	  customer.navigateToStorePageFromSubMenu();
	  customer.verifyStatusAfterToggle();
	  logger.info("********TC execution completed*****************"); }

	@Test(priority = 1)
	public void verifyLoggedinCustomerTest() throws InterruptedException {
		logger.info("********Verify logged customer TC execution started*****************");
		logger.info("========Navigate to my profile page==============");
		customer.navigateToMyProfilePage();
		customer.verifyLoginCustomer();
		logger.info("********Verify logged customer TC execution completed*****************");
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
