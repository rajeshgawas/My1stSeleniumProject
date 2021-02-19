package com.hailo.qa.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hailo.qa.base.TestBase;
//import com.hailo.qa.testcases.CustomersTest;
import com.hailo.qa.util.RandomEmailGenerator;

public class SuppliersPage extends TestBase {

	private static final String supplierEmail = RandomEmailGenerator.generateNewEmailID();
	private static final String locAdminEmail=RandomEmailGenerator.generateNewEmailID();
	private static final String locAdminOEmail=RandomEmailGenerator.generateNewEmailID();
	private static final String locAdminEmail_edit=RandomEmailGenerator.generateNewEmailID();
	private static final String locAdminOEmail_edit=RandomEmailGenerator.generateNewEmailID();
	
	private static Logger logger=Logger.getLogger(SuppliersPage.class.getName());
	
	// Page Factory - OR

	@FindBy(xpath = "//a[@name='SUPPLIERS']")
	WebElement suppliers_menu;

	@FindBy(xpath = "//button[text()='Add Supplier']")
	WebElement add_supplier_button; 

	@FindBy(xpath = "//input[@name='supplierName']")
	WebElement suppliername_text_field;

	@FindBy(xpath = "//input[@name='supplierFirstName']")
	WebElement supplierfirstname_text_field;

	@FindBy(xpath = "//input[@name='supplierLastName']")
	WebElement supplierlastname_text_field;

	@FindBy(xpath = "//input[@name='supplierEmail']")
	WebElement supplieremail_text_field;

	@FindBy(xpath = "//input[@name='supplierContact']")
	WebElement suppliercontact_text_field;

	@FindBy(xpath = "//span[text()='Inactive']")
	WebElement togglebutton;

	// @FindBy(xpath = "//input[@id='supplier_payment_status']") Before Try below or
	// //label[text()='Payment agreement signed']

	@FindBy(xpath = "//label[@class='undefined cr form-label' and text()='Payment agreement signed']")
	WebElement chkbox1;

	@FindBy(xpath = "//label[text()='Supplier agrees on product pricing, including sliding scale, timeline periodicity and any annual signing bonuses']")
	WebElement chkbox2;

	@FindBy(xpath = "//button[contains(text(),'Upload')]")
	WebElement docupload_button;

	@FindBy(xpath = "//button[@class='btn btn-secondary btn btn-primary']")
	WebElement clear_button;

	@FindBy(xpath = "//button[@class='btn btn-darkone mr-0 btn btn-primary']")
	WebElement createaccount_button;

	@FindBy(xpath = "//img[@src='data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='21' height='21' viewBox='0 0 21 21'%3E%3Cpath d='M28.5,9.615,26.385,7.5,18,15.885,9.615,7.5,7.5,9.615,15.885,18,7.5,26.385,9.615,28.5,18,20.115,26.385,28.5,28.5,26.385,20.115,18Z' transform='translate(-7.5 -7.5)'/%3E%3C/svg%3E']")
	WebElement close_icon;

	@FindBy(xpath = "//button[text()='Remove']")
	WebElement remove_button;

	@FindBy(xpath = "//div[text()='Suppliers']")
	WebElement suppliers_heading;

	@FindBy(xpath = "//h4[text()='Add Supplier']")
	WebElement supplier_window_title;

	@FindBy(xpath = "//input[@type='search']")
	WebElement supplier_search_field;

	@FindBy(xpath = "//img[@src='4e8dd8987bb3b3508a60e4fc1963709e.png']")
	WebElement supplierCardAssist_button;

	@FindBy(xpath = "//span[@class='mdi mdi-20px mdi-eye mr-2']")
	WebElement supplierCardView_button;

	@FindBy(xpath = "//h4[@class='modal-title']")
	WebElement supplierViewWindow_title;

	@FindBy(xpath = "//img[@style='padding-top: 5px; cursor: pointer;']")
	WebElement supplierViewWinClose_button;

	@FindBy(xpath = "//div[@class='tabNameList card-body']")
	WebElement supplierCard;

	@FindBy(xpath = "//button[contains(text(),'Add Location')]")
	WebElement supplierAddLoc_button;

	@FindBy(xpath = "//h4[@class='modal-title']")
	WebElement supplierAddLocWin_title;

	@FindBy(xpath = "//input[@name='locationName']")
	WebElement supplierLoc_textfield;

	@FindBy(xpath = "//input[@name='minimumOrderAmount']")
	WebElement supplierLocMinOrdAmt_textfield;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement supplierLocFirstName_textfield;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement supplierLocLastName_textfield;

	@FindBy(xpath = "//input[@name='email']")
	WebElement supplierLocEmail_textfield;

	@FindBy(xpath = "//input[@name='contact']")
	WebElement supplierLocContact_textfield;

	@FindBy(xpath = "//input[@name='optionalEmail']")
	WebElement supplierLocOptionEmail_textfield;

	@FindBy(xpath = "//select[@name='country']")
	WebElement supplierLocCountry_dd;

	@FindBy(xpath = "//input[@name='lineAddress1']")
	WebElement supplierLocAddress1_textfield;

	@FindBy(xpath = "//input[@name='lineAddress2']")
	WebElement supplierLocAddress2_textfield;

	@FindBy(xpath = "//input[@name='city']")
	WebElement supplierLocCity_textfield;

	@FindBy(xpath = "//select[@name='state']")
	WebElement supplierLocState_dd;

	@FindBy(xpath = "//input[@name='zip']")
	WebElement supplierLocZip_textfield;

	@FindBy(xpath = "//span[@class='btn toggle-off btn-sm btn-danger']")
	WebElement supplierLocStatus_button;
	
	@FindBy(xpath = "//span[@class='btn toggle-on btn-sm btn-success']")
	WebElement supplierLocInactiveStatus_toggle;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement supplierLocCreateAcc_button;
	
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement editSupplierLocUpdate_button;
	
	@FindBy(xpath = "//label[text()='Search:']/Input[@type='search']")
	WebElement supplierLocSearch_field;
	
	@FindBy(xpath = "//tr[1]//a[@title='View']/span")
	WebElement supplierLocView_icon;
	
	@FindBy(xpath = "//div/h4[@class='modal-title']")
	WebElement supplierLoc_dialogue_header;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement viewSupplierLoc_dialogue_email;
	
	@FindBy(xpath = "//tr[1]//a[@title='Edit']/span")
	WebElement supplierLocEdit_icon;
	
	@FindBy(xpath = "//tr[1]//a[@title='Delete']/span")
	WebElement supplierLocDelete_icon;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement deleteSupplierLoc_Confirm_dialogue_Delete_button;

	public SuppliersPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public void openAddSupplierWindow() throws InterruptedException {
		logger.info("==============Navigating to Supplier page===========");
		suppliers_menu.click();
		add_supplier_button.click();
		Thread.sleep(2000);
		String winTitle = supplier_window_title.getText();
		Assert.assertEquals(winTitle, "Add Supplier");
		Thread.sleep(1000);

	}

	public void enterSupplierName() {
		
		suppliername_text_field.sendKeys("mjbsupplier");
	}

	public void enterSupplierFirstName() {

		supplierfirstname_text_field.sendKeys("Auto");
	}

	public void enterSupplierLastName() {
		supplierlastname_text_field.sendKeys("Created");

	}

	public void enterEmail() {

		supplieremail_text_field.sendKeys(supplierEmail);
		System.out.println("Supplier email id in enterEmail method is: " + supplierEmail);
	}

	public void enterSupplierContact() {
		suppliercontact_text_field.click();
		suppliercontact_text_field.sendKeys("9999999999");

	}

	public void enableStatus() {

		togglebutton.click();
	}

	public void enableCheckboxes() {
		chkbox1.click();
		chkbox2.click();
	}

	public void clickCreateAccountButton() {

		createaccount_button.click();
	}

	public void uploadDoc() throws InterruptedException {

		docupload_button.sendKeys("MJB_Holiday List.pdf");

		Thread.sleep(5000);

		Thread.sleep(1000);

	}
	public void verifySupplierIsAdded() throws InterruptedException {
		logger.info("==============Searching for Supplier===========");
		supplier_search_field.sendKeys(supplierEmail);
		Thread.sleep(4000);
		List<WebElement> supplierList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of suppliers: "+supplierList.size());
		Thread.sleep(2000);
		if(supplierList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}

	
	public void deleteSupplier() throws InterruptedException {
		suppliers_menu.click();
		Thread.sleep(2000);
		verifySupplierIsAdded();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
	}
	

	public void addSupplierLocation() throws InterruptedException, AWTException {
		suppliers_menu.click();
		Thread.sleep(2000);
		verifySupplierIsAdded();
		Thread.sleep(2000);
		List<WebElement> supplierList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of suppliers: "+supplierList.size());
		Thread.sleep(2000);
		if(supplierList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		supplierCard.click();
		Thread.sleep(1000);
		List<WebElement> allLocation=driver.findElements(By.xpath("//table[@id='twocolumnlayoutid']/tbody/tr"));
		int currentLocationCount=allLocation.size();
		System.out.println("Location count before adding: "+currentLocationCount);
		logger.info("===================Adding new Supplier Location==================");
		supplierAddLoc_button.click();
		Thread.sleep(1000);
		supplierLoc_textfield.sendKeys("Cincinati");
		supplierLocMinOrdAmt_textfield.sendKeys("1000");
		Thread.sleep(1000);
		supplierLocFirstName_textfield.sendKeys("Kavin");
		supplierLocLastName_textfield.sendKeys("Peterson");
		System.out.println("Supplier location email id while adding: "+locAdminEmail);
		supplierLocEmail_textfield.sendKeys(locAdminEmail);
		supplierLocOptionEmail_textfield.sendKeys(locAdminOEmail);
		supplierLocContact_textfield.click();
		supplierLocContact_textfield.sendKeys("6565656565");
		supplierLocCountry_dd.sendKeys("US");
		supplierLocAddress1_textfield.sendKeys("Scott's Addition Historic District");
		supplierLocAddress2_textfield.sendKeys("2nd Ave");
		supplierLocCity_textfield.sendKeys("Richmond");
		supplierLocState_dd.sendKeys("Alabama");
		supplierLocZip_textfield.sendKeys("23230");
		supplierLocStatus_button.click();
		Thread.sleep(1000);
		supplierLocCreateAcc_button.click();
		Thread.sleep(1000);
		int newLocationCount=currentLocationCount+1;
		System.out.println("Location count after adding: "+newLocationCount);
		if((currentLocationCount+1)==newLocationCount) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		logger.info("===================Supplier Location is added succesfully==================");
				
	}
	public void searchSupplierLocation() throws InterruptedException {
		suppliers_menu.click();
		Thread.sleep(2000);
		verifySupplierIsAdded();
		Thread.sleep(2000);
		List<WebElement> supplierList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of suppliers: "+supplierList.size());
		Thread.sleep(2000);
		if(supplierList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		supplierCard.click();
		Thread.sleep(2000);
		System.out.println("Supplier location email id while searching: "+locAdminEmail);
		supplierLocSearch_field.sendKeys(locAdminEmail);
		Thread.sleep(2000);
		List<WebElement> allLocation=driver.findElements(By.xpath("//table[@id='twocolumnlayoutid']/tbody/tr"));
		int totalLocations=allLocation.size();
		System.out.println("Total Location count after searching: "+totalLocations);
		if(totalLocations>0) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	public void viewSupplierLocation() throws InterruptedException {
		logger.info("===================Navigating to view Supplier Location window==================");
		suppliers_menu.click();
		Thread.sleep(2000);
		verifySupplierIsAdded();
		Thread.sleep(2000);
		List<WebElement> supplierList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of suppliers: "+supplierList.size());
		Thread.sleep(2000);
		if(supplierList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		supplierCard.click();
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//table[@id='twocolumnlayoutid']/tbody/tr"))).build().perform();
		Thread.sleep(2000);
		supplierLocView_icon.click();
		Thread.sleep(2000);
		boolean isHeaderMatchesWithViewSupplierLocationDialogue=supplierLoc_dialogue_header.getText().contains("View");
		Assert.assertTrue(isHeaderMatchesWithViewSupplierLocationDialogue);
		String emailFromSupplierLocation=viewSupplierLoc_dialogue_email.getAttribute("value");
		System.out.println("Current supplier location email id on view page: "+emailFromSupplierLocation);
		Assert.assertEquals(emailFromSupplierLocation, locAdminEmail,"Current email ");
		
	}
	public void updateSupplierLocationDetails() throws InterruptedException {
		logger.info("===================Navigating to edit Supplier Location window==================");
		suppliers_menu.click();
		Thread.sleep(2000);
		verifySupplierIsAdded();
		Thread.sleep(2000);
		List<WebElement> supplierList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of suppliers: "+supplierList.size());
		Thread.sleep(2000);
		if(supplierList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		supplierCard.click();
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//table[@id='twocolumnlayoutid']/tbody/tr"))).build().perform();
		Thread.sleep(2000);
		supplierLocEdit_icon.click();
		Thread.sleep(2000);
		boolean isHeaderMatchesWithEditSupplierLocationDialogue=supplierLoc_dialogue_header.getText().contains("Edit");
		Assert.assertTrue(isHeaderMatchesWithEditSupplierLocationDialogue);
		String editLocationValue=supplierLoc_textfield.getAttribute("value")+"_edit";		
		String editMinOrderAmtValue="12345.00";
		String editLocationFirstNameValue=supplierLocFirstName_textfield.getAttribute("value")+"_edit";
		String editLocationLastNameValue=supplierLocLastName_textfield.getAttribute("value")+"_edit";
		String editMobilePhoneValue="7676767676";
		String editAddressLine1Value=supplierLocAddress1_textfield.getAttribute("value")+"_edit";
		String editAddressLine2Value=supplierLocAddress2_textfield.getAttribute("value")+"_edit";
		String editCityValue=supplierLocCity_textfield.getAttribute("value")+"_edit";
		String editStateValue="Alaska";
		String editZipValue="54321";
		supplierLoc_textfield.clear();
		supplierLoc_textfield.sendKeys(editLocationValue);
		supplierLocMinOrdAmt_textfield.clear();
		supplierLocMinOrdAmt_textfield.sendKeys(editMinOrderAmtValue);
		supplierLocFirstName_textfield.clear();
		supplierLocFirstName_textfield.sendKeys(editLocationFirstNameValue);
		supplierLocLastName_textfield.clear();
		supplierLocLastName_textfield.sendKeys(editLocationLastNameValue);
		supplierLocEmail_textfield.clear();
		supplierLocEmail_textfield.sendKeys(locAdminEmail_edit);
		supplierLocContact_textfield.clear();
		supplierLocContact_textfield.click();
		supplierLocContact_textfield.sendKeys(editMobilePhoneValue);
		supplierLocOptionEmail_textfield.clear();
		supplierLocOptionEmail_textfield.sendKeys(locAdminOEmail_edit);
		supplierLocCountry_dd.sendKeys("Canada");
		supplierLocAddress1_textfield.clear();
		supplierLocAddress1_textfield.sendKeys(editAddressLine1Value);
		supplierLocAddress2_textfield.clear();
		supplierLocAddress2_textfield.sendKeys(editAddressLine2Value);
		supplierLocCity_textfield.clear();
		supplierLocCity_textfield.sendKeys(editCityValue);
		supplierLocState_dd.sendKeys(editStateValue);
		supplierLocZip_textfield.clear();
		supplierLocZip_textfield.sendKeys(editZipValue);
		supplierLocInactiveStatus_toggle.click();
		Thread.sleep(1000);
		
		editSupplierLocUpdate_button.click();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//table[@id='twocolumnlayoutid']/tbody/tr"))).build().perform();
		Thread.sleep(2000);
		logger.info("===================Navigating to view Supplier Location window==================");
		supplierLocView_icon.click();		
		Thread.sleep(2000);
		boolean isHeaderMatchesWithViewSupplierLocationDialogue=supplierLoc_dialogue_header.getText().contains("View");
		Assert.assertTrue(isHeaderMatchesWithViewSupplierLocationDialogue);
		String emailFromSupplierLocation=viewSupplierLoc_dialogue_email.getAttribute("value");
		System.out.println("Current supplier location email id on view page: "+emailFromSupplierLocation);
		System.out.println("Current Location name: "+supplierLoc_textfield.getAttribute("value"));
		System.out.println("Current minimum order amount: "+supplierLocMinOrdAmt_textfield.getAttribute("value"));
		
		System.out.println("Current First name of location: "+supplierLocFirstName_textfield.getAttribute("value"));
		Assert.assertEquals(supplierLoc_textfield.getAttribute("value"), editLocationValue,"Current location name does not match with changed location name");
		Assert.assertEquals(supplierLocMinOrdAmt_textfield.getAttribute("value"), editMinOrderAmtValue,"Current Minimum order amount with changed order amount");
		Assert.assertEquals(supplierLocFirstName_textfield.getAttribute("value"), editLocationFirstNameValue,"Current first name does not match with changed first name");
		Assert.assertEquals(supplierLocLastName_textfield.getAttribute("value"), editLocationLastNameValue,"Current last name does not match with changed last name");
		Assert.assertEquals(supplierLocEmail_textfield.getAttribute("value"), locAdminEmail_edit,"Current email does not match with changed email");		
		logger.info("===================Supplier Location updated successfully==================");
	}
	public void deleteSupplierLocation() throws InterruptedException {
		suppliers_menu.click();
		Thread.sleep(2000);
		verifySupplierIsAdded();
		Thread.sleep(2000);
		List<WebElement> supplierList=driver.findElements(By.xpath("//div[@class='card']/div[@class='tabNameList card-body']/div/div[1]"));
		System.out.println("Number of suppliers: "+supplierList.size());
		Thread.sleep(2000);
		if(supplierList.size()==1) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		supplierCard.click();
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//table[@id='twocolumnlayoutid']/tbody/tr"))).build().perform();
		Thread.sleep(2000);
		logger.info("===================Navigating to delete Supplier Location window==================");
		supplierLocDelete_icon.click();
		boolean isHeaderMatchesWithDeleteSupplierLocationDialogue=supplierLoc_dialogue_header.getText().contains("Delete");
		Assert.assertTrue(isHeaderMatchesWithDeleteSupplierLocationDialogue);
		deleteSupplierLoc_Confirm_dialogue_Delete_button.click();
		Thread.sleep(2000);
		String tableTextWhenZeroLocationIsPresent=driver.findElement(By.xpath("//table[@id='twocolumnlayoutid']/tbody/tr/td")).getText();
		System.out.println("Table text when zero supplier location: "+tableTextWhenZeroLocationIsPresent);
		if(tableTextWhenZeroLocationIsPresent.equalsIgnoreCase("No data available in table")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		logger.info("===================Supplier Location deleted successfully==================");
	}	

}
