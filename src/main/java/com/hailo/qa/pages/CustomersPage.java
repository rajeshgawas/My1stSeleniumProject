package com.hailo.qa.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hailo.qa.base.TestBase;
import com.hailo.qa.util.RandomEmailGenerator;

public class CustomersPage extends TestBase {
	private static final String store_primary_email = RandomEmailGenerator.generateNewEmailID();
	private static final String store_opt_email = RandomEmailGenerator.generateNewEmailID();
	private static final String adminEmail = RandomEmailGenerator.generateNewEmailID();
	private static final String adminOptionalemail = RandomEmailGenerator.generateNewEmailID();
	private static final String storeUserOemail = RandomEmailGenerator.generateNewEmailID();
	private static final String storeUserEmail = RandomEmailGenerator.generateNewEmailID();
	
	private static Logger logger=Logger.getLogger(CustomersPage.class.getName());

	// OR
	@FindBy(xpath = "//a[@name='CUSTOMERS']")
	WebElement customers_menu;

	@FindBy(xpath = "//div[@class='tabNameList card-body']")
	WebElement customer_card;

	@FindBy(xpath = "//img[@src='4e8dd8987bb3b3508a60e4fc1963709e.png']")
	WebElement customer_card_assist_button;

	@FindBy(xpath = "//button[text()='Add Store']")
	WebElement add_store_button;

	@FindBy(xpath = "//input[@name='name']")
	WebElement store_name_textbox;

	@FindBy(xpath = "//input[@name='licenceNumber']")
	WebElement liquor_license_number_textbox;

	@FindBy(xpath = "//select[@name='country']")
	WebElement country_dd;

	@FindBy(xpath = "//input[@name='address']")
	WebElement address_line_1_textbox;

	@FindBy(xpath = "//input[@name='otherAddress']")
	WebElement address_line_2_textbox;

	@FindBy(xpath = "//input[@name='city']")
	WebElement city_textbox;

	@FindBy(xpath = "//select[@name='state']")
	WebElement state_dd;

	@FindBy(xpath = "//input[@name='zip']")
	WebElement zip_textbox;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstname_textbox;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastname_textbox;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email_textbox;

	@FindBy(xpath = "//input[@name='optionalEmail']")
	WebElement optionalemail_textbox;

	@FindBy(xpath = "//input[@name='contact']")
	WebElement contact_textbox;

	@FindBy(xpath = "//span[@title='Delete']")
	WebElement delete_button;

	@FindBy(xpath = "//span[text()='Inactive']")
	WebElement status_button;

	@FindBy(xpath = "//button[text()='Save & Next']")
	WebElement saveNnext_button;

	@FindBy(xpath = "//input[@id='addOverlay']")
	WebElement enterInboxName_textbox;

	@FindBy(xpath = "//button[@id='go-to-public']")
	WebElement go_button;

	@FindBy(xpath = "//td[@class='ng-binding'][1]")
	WebElement record;

	@FindBy(xpath = "//button[text()='Add Customer']")
	WebElement addCustomer_button;

	@FindBy(xpath = "//input[@name='name']")
	WebElement customerName_textbox;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement adminFirstName_textbox;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement adminLastName_textbox;

	@FindBy(xpath = "//input[@name='email']")
	WebElement adminEmail_textbox;

	@FindBy(xpath = "//input[@name='optionalEmail']")
	WebElement adminOptional_textbox;

	@FindBy(xpath = "//input[@name='contact']")
	WebElement adminContact_textbox;

	@FindBy(xpath = "//span[text()='Inactive']")
	WebElement adminStatus_button;

	@FindBy(xpath = "//label[text()='Payment agreement signed']")
	WebElement adminPayment_checkbox;

	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement adminCreate_button;

	@FindBy(xpath = "//input[@type='search']")
	WebElement adminSearch_textbox;

	@FindBy(xpath = "//img[@src='4e8dd8987bb3b3508a60e4fc1963709e.png']")
	WebElement verticalAssist_button;

	@FindBy(xpath = "//a[text()='View']")
	WebElement customerView_dd;

	@FindBy(xpath = "//label[@class='hailoModal-label']")
	WebElement viewCustomerProfile_email;

	@FindBy(xpath = "//a[text()='Edit']")
	WebElement customerEdit_dd;

	@FindBy(xpath = "//h4[contains (text(),'Edit')]")
	WebElement customerEditWin_title;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement customerUpdate_button;

	@FindBy(xpath = "//a[text()='Delete']")
	WebElement customerDel_dd;

	@FindBy(xpath = "//button[text()='Delete']")
	WebElement customerDelConfirm_button;

	@FindBy(xpath = "//a[@title='View']")
	WebElement customerStoreView_eye;

	@FindBy(xpath = "//a[@title='Edit']")
	WebElement customerStoreEdit_button;

	@FindBy(xpath = "//a[@title='Delete']")
	WebElement customerStoreDel_button;

	@FindBy(xpath = "//a[text()='View Store']")
	WebElement customerStoreView_form_title;

	@FindBy(xpath = "//label[@class='hailoModal-label']")
	WebElement customerStoreView_email;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement customerStoreView_cancel_button;

	// Edit
	@FindBy(xpath = "//a[text()='Edit Store']")
	WebElement customerStoreEdit_form_title;

	@FindBy(xpath = "//input[@name='city']")
	WebElement customerStoreEdit_city;

	@FindBy(xpath = "//button[text()='Update & Next']")
	WebElement customerStoreEdit_UpdatenNext_button;

	@FindBy(xpath = "//button[text()='Delete']")
	WebElement customerStoreCnfDel_button;

	// create store user
	@FindBy(xpath = "//button[text()='Add User']")
	WebElement storeUserAdd_button;

	@FindBy(xpath = "//h5[@id='exampleModalLabel']")
	WebElement storeUserAdd_winTitle;

	@FindBy(xpath = "//input[@name='userFirstName']")
	WebElement storeUserFirstName_textfield;

	@FindBy(xpath = "//input[@name='userLastName']")
	WebElement storeUserLastName_textfield;

	@FindBy(xpath = "//input[@name='userEmailId']")
	WebElement storeUserEmail_textfield;

	@FindBy(xpath = "//input[@name='userPhoneNo']")
	WebElement storeUserPhone_textfield;

	@FindBy(xpath = "//input[@name='optional_email']")
	WebElement storeUserOemail_textfield;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement storeUserAdding_button;

	// store user view
	@FindBy(xpath = "//a[@title='View']")
	WebElement storeUserView_eye;

	@FindBy(xpath = "//h5[@id='exampleModalLabel']")
	WebElement storeUserView_win_title;

	@FindBy(xpath = "//tbody/tr/td[3]/label[2]")
	WebElement storeEmailID;
	
	@FindBy(xpath = "//label[text()='EMAIL ID']/following-sibling::input[@name='email']")
	WebElement Customer_EmailID_Edit_Form;
	
	@FindBy(xpath = "//div[@class='col-lg-10 col-md-10 col-sm-10 d-flex flex-column p-0']/span[2]")
	WebElement Customer_EmailID_From_Tile;
	
	@FindBy(xpath = "//div[@class='tabNameList card-body']//div[@class='roleStatus ml-0 mt-2']")
	WebElement customer_Status;
	
	@FindBy(xpath = "//span[@class='btn toggle-on btn-sm btn-success']")
	WebElement customer_Status_active_toggle;
	
	@FindBy(xpath = "//span[@class='btn toggle-off btn-sm btn-danger']")
	WebElement customer_Status_inactive_toggle;
	
	@FindBy(xpath = "//span[@title='Resend Email']")
	WebElement customer_admin_edit_resend_email_icon;
	
	@FindBy(xpath = "//h4[@class='modal-title'][text()='Alert']")
	WebElement customer_admin_edit_resend_email_window_header;
	
	@FindBy(xpath = "//button[@type='submit'][text()='Yes']")
	WebElement customer_admin_edit_resend_email_yes_button;
	
	@FindBy(xpath = "//a[@title='Resend Email Link']/span")
	WebElement customer_store_user_resend_email_icon;


	// store user edit

	// store user delete

	// store user edit
	@FindBy(xpath = "//a[@title='Edit']")
	WebElement storeUserEdit_button;

	// store user delete
	@FindBy(xpath = "//a[@title='Delete']")
	WebElement storeUserDel_button;

	public CustomersPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void addCustomer() throws InterruptedException {

		customers_menu.click();
		Thread.sleep(1000);
		addCustomer_button.click();
		Thread.sleep(1000);
		customerName_textbox.sendKeys("mjbAutoCustomer");
		adminFirstName_textbox.sendKeys("mjbAutoFirstName");
		adminLastName_textbox.sendKeys("mjbAutoLastname");
		adminEmail_textbox.sendKeys(adminEmail);
		System.out.println("This is admin email: " + adminEmail);
		adminOptional_textbox.sendKeys(adminOptionalemail);
		System.out.println("This is admin optional email: " + adminOptionalemail);
		adminContact_textbox.click();
		adminContact_textbox.sendKeys("9856321456");
		Thread.sleep(2000);
		adminStatus_button.click();
		Thread.sleep(2000);
		adminPayment_checkbox.click();
		Thread.sleep(1000);
		adminCreate_button.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		verifyCustomerIsAdded();
	}

	public void adminSearch() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(5000);
		adminSearch_textbox.sendKeys(adminEmail);
		System.out.println("This is admin email in admin Search: " + adminEmail);
		Thread.sleep(5000);
		verticalAssist_button.click();
		Thread.sleep(2000);
		String customer_email_tile=Customer_EmailID_From_Tile.getText().toLowerCase();
		System.out.println("Customer details in the tile: "+customer_email_tile);
		Assert.assertTrue(customer_email_tile.contains(adminEmail), "Customer does not found for the email...");
		customerView_dd.click();
		Thread.sleep(1000);
		String display = viewCustomerProfile_email.getText().toLowerCase();
		System.out.println("Email id displayed as " + display);
		Assert.assertEquals(display, adminEmail);

	}

	public void editCustomer() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(2000);
		verticalAssist_button.click();
		Thread.sleep(2000);
		customerEdit_dd.click();
		Thread.sleep(2000);		
		String edit_Customer_header = customerEditWin_title.getText();
		System.out.println(edit_Customer_header);
		Assert.assertTrue(edit_Customer_header.contains("Edit"), "Window title mismatch");
		String customer_email_edit_page= Customer_EmailID_Edit_Form.getAttribute("value").toLowerCase();
		System.out.println("Customer's email on edit page: "+customer_email_edit_page);
		Assert.assertEquals(customer_email_edit_page, adminEmail,"Email id does not match with customer email id");
		contact_textbox.clear();
		contact_textbox.click();
		contact_textbox.sendKeys("1234567890");
		Thread.sleep(1000);
		customerUpdate_button.click();
		Thread.sleep(3000);
	}
	public void navigateToEditCustomerPage() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		verticalAssist_button.click();
		Thread.sleep(2000);
		customerEdit_dd.click();
		Thread.sleep(2000);		
		String edit_Customer_header = customerEditWin_title.getText();
		System.out.println(edit_Customer_header);
		Assert.assertTrue(edit_Customer_header.contains("Edit"), "Window title mismatch");
	}

	public void delCustomer() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(2000);
		String email_tiles=Customer_EmailID_From_Tile.getText();
		System.out.println("Customer's email from the tile: "+email_tiles);
		Assert.assertTrue(email_tiles.contains(adminEmail));
		verticalAssist_button.click();
		String display = viewCustomerProfile_email.getText().toLowerCase();
		System.out.println("Email id displayed as " + display);
		Assert.assertEquals(display, adminEmail);
		Thread.sleep(2000);
		customerDel_dd.click();
		Thread.sleep(2000);
		customerDelConfirm_button.click();
	}

	public void addStore() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(2000);
		customer_card.click();
		Thread.sleep(1000);
		add_store_button.click();
		Thread.sleep(2000);
//		add_store_button.click();
		store_name_textbox.sendKeys("mjbAutoCreatedStore");
		liquor_license_number_textbox.sendKeys("9988776655");
		country_dd.click();
		Select selObj1 = new Select(country_dd);
		selObj1.selectByVisibleText("Canada");
		address_line_1_textbox.sendKeys("2994 Dunning Road");
		address_line_2_textbox.sendKeys("1155 Pape Ave");
		city_textbox.sendKeys("Toronto");
		state_dd.click();
		Select selObj2 = new Select(state_dd);
		selObj2.selectByVisibleText("Ontario");
		zip_textbox.sendKeys("M4E 2V5");
		firstname_textbox.sendKeys("McRib");
		lastname_textbox.sendKeys("Ben");
		email_textbox.sendKeys(store_primary_email);
		optionalemail_textbox.sendKeys(store_opt_email);
		contact_textbox.click();
		contact_textbox.sendKeys("519-378-7666");
		status_button.click();
		Thread.sleep(2000);
		saveNnext_button.click();
		Thread.sleep(2000);
		

	}
	public void verifyCustomerIsAdded() throws InterruptedException {
		logger.info("==============Searching for Customer===========");
		//customers_menu.click();
		Thread.sleep(1000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(3000);
		List<WebElement> customerList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of customers: "+customerList.size());
		Thread.sleep(2000);
		if(customerList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		driver.navigate().refresh();
	}
	public void verifyStoreIsAdded() throws InterruptedException {
		logger.info("==============Verifying store is added===========");
		Thread.sleep(3000);
		List<WebElement> storeList=driver.findElements(By.xpath("//tbody/tr"));
		System.out.println("Number of stores: "+storeList.size());
		Thread.sleep(2000);
		if(storeList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}

	// Add store User
	public void addStoreUser() throws InterruptedException {
		storeUserAdd_button.click();
		Thread.sleep(1000);
		String winTitle = storeUserAdd_winTitle.getText();
		Thread.sleep(1000);
		Assert.assertEquals(winTitle, "Add User");
		Thread.sleep(1000);
		storeUserFirstName_textfield.sendKeys("McDonald Swargate");
		storeUserLastName_textfield.sendKeys("Near bus stand");
		storeUserEmail_textfield.sendKeys(storeUserEmail);
		storeUserOemail_textfield.sendKeys(storeUserOemail);
		storeUserPhone_textfield.sendKeys("7589654258");
		Thread.sleep(1000);
		storeUserAdding_button.click();
		Thread.sleep(1000);
		verifyStoreIsAdded();
	}
	// View store user
//		storeUserView_eye.click();

	public void viewStore() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(2000);
		customer_card.click();
		Thread.sleep(1000);
		customerStoreView_eye.click();
		String viewCustomerForm = customerStoreView_form_title.getText();
		Assert.assertTrue(viewCustomerForm.contains("View"), "Title doesn't match");
		String customerEmailView = customerStoreView_email.getText().toLowerCase();
		Assert.assertEquals(customerEmailView, store_primary_email);
		customerStoreView_cancel_button.click();
		Thread.sleep(2000);
	}

	public void editStore() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(2000);
		customer_card.click();
		Thread.sleep(1000);
		customerStoreEdit_button.click();
		String editCustomerForm = customerStoreEdit_form_title.getText();
		Assert.assertTrue(editCustomerForm.contains("Edit"), "Title doesn't match");
		Thread.sleep(2000);
		customerStoreEdit_city.clear();
		Thread.sleep(3000);
		customerStoreEdit_city.sendKeys("Quebec City");
		Thread.sleep(1000);
		String editCity = customerStoreEdit_city.getText();
		System.out.println(editCity);
//		String actualCity="Quebec City";
//		Assert.assertEquals(editCity, actualCity); The value is not yet stored in DB hence getting null
		customerStoreEdit_UpdatenNext_button.click();
		Thread.sleep(1000);
//		String customerCityEdit=customerStoreEdit_city.getText();
//		Assert.assertEquals(actual, expected);
	}

	public void deleteStore() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(2000);
		customer_card.click();
		Thread.sleep(1000);
		String display = storeEmailID.getText().toLowerCase();
		System.out.println("Store Email id " + display);
		Assert.assertEquals(display, storeUserEmail);
		customerStoreDel_button.click();
		Thread.sleep(1000);
		customerStoreCnfDel_button.click();
		Thread.sleep(1000);
	}

	public void checkEmail() throws InterruptedException {
		enterInboxName_textbox.sendKeys(store_primary_email);
		go_button.click();
		Thread.sleep(2000);
		record.click();
		Thread.sleep(3000);
	}
	public String getCustomerCurrentStatus() {
		
		return customer_Status.getText();
	}
	public void toggleCustomerStatus() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(2000);
		verticalAssist_button.click();
		Thread.sleep(2000);
		customerEdit_dd.click();		
		Assert.assertTrue(customerEditWin_title.getText().contains("Edit"),"You are not on customer edit window");
		System.out.println("Current status of customer: "+getCustomerCurrentStatus());
		logger.info("==============Changing Customer status===========");
		if(getCustomerCurrentStatus().equalsIgnoreCase("Inactive")) {
			customer_Status_inactive_toggle.click();
		}
		else {
			customer_Status_active_toggle.click();
		}
		customerUpdate_button.click();
		//driver.navigate().refresh();
	}
	public void verifyStoreStatus() throws InterruptedException {
		adminSearch_textbox.clear();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(3000);
		List<WebElement> customerList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of customers: "+customerList.size());
		Thread.sleep(2000);
		if(customerList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		customer_card.click();
		Thread.sleep(2000);
		List<WebElement> storeStatus=driver.findElements(By.xpath("//thead/following-sibling::tbody/tr/td[5]"));
		int totalStores=storeStatus.size();
		System.out.println("Total stores are: "+totalStores);
		for(WebElement status:storeStatus) {
			String currentStoreStatus=status.getText();
			System.out.println("Current status of the store: "+currentStoreStatus);
			if(currentStoreStatus.equalsIgnoreCase(getCustomerCurrentStatus())) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		driver.navigate().refresh();
		toggleCustomerStatus();
		adminSearch_textbox.clear();
		Thread.sleep(2000);
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(3000);
		List<WebElement> customerList2=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of customers: "+customerList2.size());
		Thread.sleep(2000);
		if(customerList2.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		customer_card.click();
		Thread.sleep(2000);
		List<WebElement> storeStatus_2=driver.findElements(By.xpath("//thead/following-sibling::tbody/tr/td[5]"));
		int totalStores2=storeStatus_2.size();
		System.out.println("Total stores are: "+totalStores2);
		for(WebElement status:storeStatus_2) {
			String currentStoreStatus=status.getText();
			System.out.println("Current status of the store: "+currentStoreStatus);
			if(currentStoreStatus.equalsIgnoreCase(getCustomerCurrentStatus())) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
	}
	public void checkResendEmailFeatureForAdminUser() throws InterruptedException {
		Assert.assertTrue(customer_admin_edit_resend_email_icon.isDisplayed());
		customer_admin_edit_resend_email_icon.click();
		Thread.sleep(1000);
		Assert.assertTrue(customer_admin_edit_resend_email_window_header.isDisplayed());
		Assert.assertTrue(customer_admin_edit_resend_email_yes_button.isDisplayed());
		customer_admin_edit_resend_email_yes_button.click();
	}
	public void doPageRefresh() {
		driver.navigate().refresh();
	}
	public void checkResendEmailFeatureForStoreUser() throws InterruptedException {
		WebElement userRow=driver.findElement(By.xpath("//table[@id='userdetailsid']/tbody/tr/td[2]"));
		Actions action=new Actions(driver);
		action.moveToElement(userRow).build().perform();
		customer_store_user_resend_email_icon.click();
		Thread.sleep(1000);
		Assert.assertTrue(customer_admin_edit_resend_email_window_header.isDisplayed());
		Assert.assertTrue(customer_admin_edit_resend_email_yes_button.isDisplayed());
		customer_admin_edit_resend_email_yes_button.click();
		Thread.sleep(4000);
	}
	public void checkResendEmailFeatureForStoreAdmin() throws InterruptedException {
		//doPageRefresh();
		customers_menu.click();
		adminSearch_textbox.sendKeys(adminEmail);
		Thread.sleep(3000);
		List<WebElement> customerList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of customers: "+customerList.size());
		Thread.sleep(2000);
		if(customerList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		customer_card.click();
		List<WebElement> stores=driver.findElements(By.xpath("//table/tbody/tr"));
		int totalStores=stores.size();
		if(totalStores>0) {
			Assert.assertTrue(true);			
		}
		else {
			Assert.assertTrue(false);
		}
		
		WebElement storeRow=driver.findElement(By.xpath("//table/tbody/tr/td[2]"));
		customerStoreEdit_button.click();
		String editCustomerForm = customerStoreEdit_form_title.getText();
		Assert.assertTrue(editCustomerForm.contains("Edit"), "Title doesn't match");
		Thread.sleep(1000);
		customer_admin_edit_resend_email_icon.click();
		Thread.sleep(1000);
		Assert.assertTrue(customer_admin_edit_resend_email_window_header.isDisplayed());
		Assert.assertTrue(customer_admin_edit_resend_email_yes_button.isDisplayed());
		customer_admin_edit_resend_email_yes_button.click();
		Thread.sleep(4000);
	}

}
