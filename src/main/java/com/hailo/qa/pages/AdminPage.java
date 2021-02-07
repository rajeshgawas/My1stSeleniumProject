package com.hailo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hailo.qa.base.TestBase;

public class AdminPage extends TestBase {

	@FindBy(xpath = "//span[text()=\"Admin\"]")
	WebElement admin;
	
	@FindBy(xpath = "//div[@class='subMenuStyle']/a[text()='Users']")
	WebElement user_Menu;
	
	@FindBy(xpath = "//table[@id='usersid']/tbody/tr[1]")
	WebElement first_user;
	
	@FindBy(xpath = "//tr[1]//div[@class='btn-group roleBtnGroup']/a[@title='Edit']")
	WebElement user_edit_icon;
	
	@FindBy(xpath = "//tr[1]/td/div/span[@class='roleStatus']")
	WebElement current_status;
	
	@FindBy(xpath = "//h5[@id='exampleModalLabel']")
	WebElement edit_user_page_title;
	
	@FindBy(xpath = "//span[@class='btn toggle-on btn-lg btn-success'][text()='Active']")
	WebElement active_status;
	
	@FindBy(xpath = "//span[@class='btn toggle-off btn-lg btn-danger'][text()='Inactive']")
	WebElement inactive_status;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement update_user_button;
	
	String user_currentStatus="";

	public AdminPage() {

		PageFactory.initElements(driver, this);
	}
	
	public void navigateToUserPage() {
		user_Menu.click();
	}
	
	public String getCurrentStatusOfUser() {
		return current_status.getText();
	}
	public void navigateToEditUserPage() throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(first_user).build().perform();
		Thread.sleep(2000);
		act.moveToElement(user_edit_icon).click().build().perform();
		//user_edit_icon.click();
		Thread.sleep(2000);
		String page_header=edit_user_page_title.getText();
		System.out.println("Page Header: "+page_header);
		if(!page_header.contains("Edit")) {
			Assert.assertTrue(false);
		}		
		
	}
	public void toggleStatusOfUser() {
		user_currentStatus=getCurrentStatusOfUser();
		if(user_currentStatus.equals("Active")) {
			active_status.click();
		}
		else if((user_currentStatus.equals("Inactive"))) {
			inactive_status.click();
		}
	}
	public void clickOnupdateUserButton() {
		update_user_button.click();
	}
	public void verifyStatusAfterToggle() {
		String user_status_after_toggle=getCurrentStatusOfUser();
		System.out.println("User's status post toggle: "+user_status_after_toggle);
		if(user_currentStatus.equals("Active")) {
			Assert.assertTrue(user_status_after_toggle.equals("Inactive"));
		}
		else if (user_currentStatus.equals("Inactive")) {
			Assert.assertTrue(user_status_after_toggle.equals("Active"));
		}
	}

}
