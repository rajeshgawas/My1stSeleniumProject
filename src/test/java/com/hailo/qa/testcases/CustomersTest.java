package com.hailo.qa.testcases;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
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
	private static Logger logger = Logger.getLogger(CustomersTest.class.getName());

	@BeforeMethod
	public void setUp(Method method) throws InterruptedException {

//		if (!method.getName().equals("createNewStore")) {
		initialization();
		loginPage = new LoginPage();
//			loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		loginPage.loginWithAdmin(prop.getProperty("admin_email"), prop.getProperty("admin_password"));
		customers = new CustomersPage();
//		}else

//		{
//			driver = new ChromeDriver();
//			Thread.sleep(1000);
//		}

	}

	@Test(priority = 1)
	public void createNewCustomer() throws InterruptedException {
		logger.info("**********Customer Creation test execution started**********");
		dashboard = new Dashboard();
		logger.info("==========Dashboard==========");
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		logger.info("==========Admin Menu==========");
		Thread.sleep(1000);
		customers.addCustomer();
		logger.info("==========Added a customer ==========");
		Thread.sleep(1000);
		logger.info("**********Customer Creation test execution completed**********");
	}

	@Test(priority = 2)
	public void searchCustomer() throws InterruptedException {
		logger.info("********** Search Customer Test execution started **********");
		dashboard = new Dashboard();
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.adminSearch();
		logger.info("********** Search Customer test "
				+ "execution completed**********");
	}

	@Test(priority=3)
	public void editCustomer() throws InterruptedException {
		logger.info("********** Edit customer Test execution started **********");
		dashboard=new Dashboard();
		Thread.sleep(2000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.editCustomer();
		Thread.sleep(2000);
		logger.info("********** Edit customer test execution completed**********");
	}

	@Test(priority = 9)
	public void delCustomer() throws InterruptedException {
	logger.info("********** Login Page Logo Test execution started **********");
		dashboard=new Dashboard();
		Thread.sleep(2000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.delCustomer();
		Thread.sleep(2000);
		customers.adminSearch();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void createNewStore() throws InterruptedException {
		logger.info("********** Create Store Test execution started **********");
		dashboard = new Dashboard();
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.addStore();
		Thread.sleep(2000);
		logger.info("********** Create Store test execution completed**********");
	}

	@Test(priority = 5)
	public void viewStore() throws InterruptedException {
		logger.info("********** View Store Test execution Started **********");
		dashboard = new Dashboard();
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.viewStore();
		Thread.sleep(1000);
		logger.info("********** View Store Test execution Completed**********");
	}

	@Test(priority = 6)
	public void editStore() throws InterruptedException {
		dashboard = new Dashboard();
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.editStore();
		Thread.sleep(1000);

	}
	//Added in the train
	@Test(priority=7)
	public void addStoreUser() throws InterruptedException {
		dashboard = new Dashboard();
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.addStoreUser();
	}
	
	@Test(priority=8)
	public void deleteStore() throws InterruptedException {
		dashboard = new Dashboard();
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.deleteStore();
		Thread.sleep(2000);
		//customers.viewStore();
		Thread.sleep(1000);
	}

//	@Test(priority = 3)
//	public void checkEmail() throws InterruptedException {
////		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
////		driver.findElement(By.linkText("https://www.mailinator.com/")).sendKeys(selectLinkOpeninNewTab);
//
//		driver.get("https://www.mailinator.com/");
//		customers.checkEmail();
//	}
	@Test(priority = 10)
	public void toggleCustomerStatus() throws InterruptedException {
		logger.info("**********Toggle Customer status test execution started**********");
		dashboard = new Dashboard();
		logger.info("==========Dashboard==========");
		Thread.sleep(1000);
		dashboard.clickonAdminMenu();
		Thread.sleep(1000);
		customers.addCustomer();
		logger.info("==========Added a customer ==========");
		Thread.sleep(1000);
		customers.addStore();
		logger.info("==========Added a store ==========");
		customers.toggleCustomerStatus();
		logger.info("==========Changed customer status==========");
		customers.verifyStoreStatus();
		logger.info("**********Toggle Customer status test execution completed**********");		
		
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
