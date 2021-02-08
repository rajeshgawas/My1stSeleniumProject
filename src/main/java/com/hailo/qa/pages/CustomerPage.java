package com.hailo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hailo.qa.base.TestBase;

public class CustomerPage extends TestBase {
	
	@FindBy(xpath = "//div[@class='dropdown drp-user']")
	WebElement my_profile_icon;
	
	@FindBy(xpath = "//a/span[@class='userProfileOption'][text()='My Profile']")
	WebElement my_profile_option;
	
	@FindBy(xpath = "//input[@name='emailId']")
	WebElement email_disable_txtField;

	@FindBy(xpath = "//button/span[text()='My Store']")
	WebElement my_store_main_menu;

	@FindBy(xpath = "//div[@class='subMenuStyle']/a[@name='My Store']")
	WebElement my_store_sub_main;

	@FindBy(xpath = "//li/a[text()='My Store']")
	WebElement my_store_header;
	
	@FindBy(xpath = "//tr[1]/td/div/span[@class='roleStatus']")
	WebElement store_current_status;
	
	@FindBy(xpath = "//table[@id='example']/tbody/tr[1]")
	WebElement first_store;
	
	@FindBy(xpath = "//tr[1]//div[@class='btn-group roleBtnGroup']/a[@title='Edit']")
	WebElement store_edit_icon;
	
	@FindBy(xpath = "//p[@class='add-store-header']")
	WebElement edit_store_page_title;
	
	@FindBy(xpath = "//span[@class='btn toggle-on btn-lg btn-success'][text()='Active']")
	WebElement active_status;
	
	@FindBy(xpath = "//span[@class='btn toggle-off btn-lg btn-danger'][text()='Inactive']")
	WebElement inactive_status;
	
	@FindBy(xpath = "//button[@type='submit'][text()='Update & Next']")
	WebElement update_store_button;
	
	
	String store_currentStatus="";

	public CustomerPage() {

		PageFactory.initElements(driver, this);
	}
	
	public void navigateToStorePage() throws InterruptedException {
		my_store_main_menu.click();
		Thread.sleep(2000);
		my_store_sub_main.click();
	}
	public void navigateToStorePageFromSubMenu() {
		my_store_sub_main.click();
	}
	
	public String getCurrentStatusOfStore() {
		return store_current_status.getText();
	}
	public void navigateToEditStorePage() throws InterruptedException {
		store_currentStatus=getCurrentStatusOfStore();
		Actions act=new Actions(driver);
		act.moveToElement(first_store).build().perform();
		Thread.sleep(2000);
		act.moveToElement(store_edit_icon).click().build().perform();
		//user_edit_icon.click();
		Thread.sleep(2000);
		String page_header=edit_store_page_title.getText();
		System.out.println("Page Header: "+page_header);
		if(!page_header.contains("Edit")) {
			Assert.assertTrue(false);
		}		
		
	}
	public void toggleStatusOfStore() {
		//store_currentStatus=getCurrentStatusOfStore();
		if(store_currentStatus.equals("Active")) {
			active_status.click();
		}
		else if((store_currentStatus.equals("Inactive"))) {
			inactive_status.click();
		}
	}
	public void clickOnupdateStoreButton() {
		update_store_button.click();
	}
	public void verifyStatusAfterToggle() {
		String store_status_after_toggle=getCurrentStatusOfStore();
		System.out.println("Store's status post toggle: "+store_status_after_toggle);
		if(store_currentStatus.equals("Active")) {
			Assert.assertTrue(store_status_after_toggle.equals("Inactive"));
		}
		else if (store_currentStatus.equals("Inactive")) {
			Assert.assertTrue(store_status_after_toggle.equals("Active"));
		}
	}

}
