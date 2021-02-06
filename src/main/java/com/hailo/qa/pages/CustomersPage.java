package com.hailo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hailo.qa.base.TestBase;

public class CustomersPage extends TestBase {

	String primary_email="mjbAutoStore13@mailinator.com";
	String sec_email="mjbAutoStore14@mailinator.com";
	// OR
	@FindBy(xpath = "//a[@name='CUSTOMERS']")
	WebElement customers_menu;

	@FindBy(xpath = "//div[@class='tabNameList card-body']")
	WebElement customer_card;

	@FindBy(xpath = "//img[@src='4e8dd8987bb3b3508a60e4fc1963709e.png']")
	WebElement customer_card_assist_button;

//	@FindBy(xpath="//a[text()='View']")
//	WebElement customer_view_button;

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

	public CustomersPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void addStore() throws InterruptedException {
		customers_menu.click();
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
		//primary_email = "mjbAutoStore9@mailinator.com";
		email_textbox.sendKeys(primary_email);
		optionalemail_textbox.sendKeys(sec_email);
		contact_textbox.click();
		contact_textbox.sendKeys("519-378-7666");
//		status_button.click();
		Thread.sleep(2000);
		saveNnext_button.click();
		Thread.sleep(2000);

	}

	public void checkEmail() throws InterruptedException {
		enterInboxName_textbox.sendKeys(primary_email);
		go_button.click();
		Thread.sleep(2000);
		record.click();
		Thread.sleep(3000);
	}

}
