package com.hailo.qa.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hailo.qa.base.TestBase;

public class SuppliersPage extends TestBase {

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

	public SuppliersPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public void openAddSupplierWindow() {

		suppliers_menu.click();
		add_supplier_button.click();

	}

	public void enterSupplierName() {
		suppliername_text_field.sendKeys("mjbsupplier");
	}

	public void enterSupplierFirstName() {

		supplierfirstname_text_field.sendKeys("Firstname");
	}

	public void enterSupplierLastName() {
		supplierlastname_text_field.sendKeys("Lastname");

	}

	public void enterEmail() {

		supplieremail_text_field.sendKeys("mjbqasupplier22@mjb.com");
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

		//docupload_button.click();
		docupload_button.sendKeys("C:/Rajesh_Docs/Hailo/ok.pdf");
		Thread.sleep(5000);
//		if ((remove_button).isDisplayed()) {
//			assertTrue(true, "File Uploaded");
//		} else {
//			assertTrue(false, "File not Uploaded");
//		}
//		String expectedfile=attached_file_name.getAttribute("okay.pdf");
//		System.out.println("Attached"+ expectedfile);
		Thread.sleep(1000);

	}

}
