package com.hailo.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hailo.qa.base.TestBase;
import com.hailo.qa.util.RandomEmailGenerator;

public class ProductCategoriesPage extends TestBase{
	
	private static final String category_name="Food";
	
	private static final String sub_category_name=RandomEmailGenerator.getSaltString();
	
	private final Logger logger=Logger.getLogger(this.getClass().getName());
	
	private static String subCategory_newValue="";
	
	
	public ProductCategoriesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class='dropdown-btn nav-link']/span[text()='Master']")
	WebElement master_menu;
	
	@FindBy(xpath = "//div[@class='subMenuStyle']/a[text()='Product Categories']")
	WebElement product_cat_submenu;
	
	@FindBy(xpath = "//div/h2[text()='Product Categories']")
	WebElement product_categories_page_header;
	
	@FindBy(xpath = "//button[text()='Add Categories']")
	WebElement add_category_button;
	
	@FindBy(xpath = "//div[@class='modal-header']/h5[@class='modal-title'][contains(text(),'Add')]")
	WebElement add_category_modal_popup_header;
	
	@FindBy(xpath = "//label[@for='rolename'][text()='Category Name']/following-sibling::input[@name='title']")
	WebElement add_category_modal_popup_categoryName_field;
	
	@FindBy(xpath = "//label[@for='description'][text()='Description']/following-sibling::textarea[@name='productDescription']")
	WebElement add_category_modal_popup_description_field;
	
	@FindBy(xpath = "//button[@class='btn btn-darkone'][contains(text(),'Add')]")
	WebElement add_category_modal_popup_addCategory_btn;	
	
	@FindBy(xpath = "//button[@class='close']/span[text()='×']")
	WebElement add_category_modal_popup_close_icon;
	
	@FindBy(xpath = "//button[text()='Add Subcategory']")
	WebElement add_subcategory_button;
	
	@FindBy(xpath = "//div[@class='modal-header']/h5[@class='modal-title'][contains(text(),'Add')]")
	WebElement add_subcategory_modal_popup_header;
	
	@FindBy(xpath = "//label[@for='rolename'][text()='SUBCATEGORY NAME']/following-sibling::input[@name='productName']")
	WebElement add_subcategory_modal_popup_name_field;
	
	@FindBy(xpath = "//button[@class='btn btn-darkone'][contains(text(),'Add')]")
	WebElement add_subcategory_modal_popup_add_btn;
	
	@FindBy(xpath = "//button[text()='Add Categories']/following-sibling::div/input[@placeholder='Search']")
	WebElement add_category_search_field;
	
	@FindBy(xpath = "//button[text()='Add Subcategory']/following-sibling::div/input[@placeholder='Search']")
	WebElement add_subcategory_search_field;
	
	@FindBy(xpath = "//ul[@class='hidebullets']/li[@class='undefinedlist_card']")
	WebElement categories_list;
	
	@FindBy(xpath = "//ul[@class='hidebullets']/li[@class='list_card']")
	WebElement subcategories_list;
	
	@FindBy(xpath = "//div[@class='col-3 white_panel'][2]//div/a[@data-toggle='dropdown']")
	WebElement subcategories_ellipsis_vertical_icon;
	
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right show']//li[1]//a[@class='dropdown-item ']")
	WebElement subcategories_view_icon;
	
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right show']//li[2]//a[@class='dropdown-item ']")
	WebElement subcategories_edit_icon;
	
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right show']//li[3]//a[@class='dropdown-item ']")
	WebElement subcategories_delete_icon;
	
	@FindBy(xpath = "//div[@class='modal-header']/h5[contains(text(),'View')]")
	WebElement view_dialogue_header;
	
	@FindBy(xpath = "//div[@class='modal-header']/h5[contains(text(),'Edit')]")
	WebElement edit_dialogue_header;
	
	@FindBy(xpath = "//input[@name='productName']")
	WebElement edit_dialogue_subcat_name_field;
	
	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Update')]")
	WebElement edit_dialogue_subcat_update_btn;
	
	@FindBy(xpath = "//button[@class='btn btn-dark'][contains(text(),'Delete')]")
	WebElement delete_dialogue_subcat_delete_btn;
	
	@FindBy(xpath = "//div[@class='modal-header']/h5[text()='Confirm']")
	WebElement delete_dialogue_header_title;
	
	public void navigateToProductCategoriesPage() throws InterruptedException {
		logger.info("==========Navigating to Product Categories page==========");
		master_menu.click();
		Thread.sleep(1000);
		product_cat_submenu.click();
		Thread.sleep(1000);
		String pc_header_title=product_categories_page_header.getText();
		Assert.assertEquals(pc_header_title, "Product Categories","You are not at Product categories page..");		
	}
	public void verifyAddNewProductCategoryPopUp () throws InterruptedException{
		logger.info("==========Navigating to Add new Product Categories modal pop up========");
		add_category_button.click();
		Thread.sleep(1000);
		String addNewCategory_modal_header=add_category_modal_popup_header.getText();
		System.out.println("Page header for add category modal pop up: "+addNewCategory_modal_header);
		Assert.assertTrue(add_category_modal_popup_header.isDisplayed());
		Thread.sleep(1000);
		add_category_modal_popup_categoryName_field.sendKeys(category_name+"_test");
		Thread.sleep(1000);
		add_category_modal_popup_description_field.sendKeys(category_name +" test description");
		Thread.sleep(1000);
		logger.info("==========Closing Add new Product Categories modal pop up========");
		add_category_modal_popup_close_icon.click();
		Assert.assertTrue(add_category_modal_popup_header.isDisplayed());
		Thread.sleep(1000);
		logger.info("==========Closed Add new Product Categories modal pop up========");
	}
	public void searchCategoryAndOpen() {
		logger.info("==========Searching for "+category_name+" category========");
		add_category_search_field.sendKeys(category_name);
		List<WebElement> categories=driver.findElements(By.xpath("//ul[@class='hidebullets']/li[@class='undefinedlist_card']"));
		if(categories.size()==0) {
			Assert.assertTrue(false, category_name+" category does not find");
		}
		logger.info("==========Select the category========");
		categories.get(0).click();
	}
	public void addNewSubcategory() throws InterruptedException {
		logger.info("==========Searching categories for food========");
		add_subcategory_button.click();
		Thread.sleep(1000);
		String add_subcategory_modal_header_title=add_subcategory_modal_popup_header.getText();
		System.out.println("Header title for add new subcategory modal pop up: "+add_subcategory_modal_header_title);
		Assert.assertTrue(add_subcategory_modal_popup_header.isDisplayed());
		Thread.sleep(1000);
		logger.info("==========Adding new subcategory========");
		add_subcategory_modal_popup_name_field.sendKeys(sub_category_name);
		Thread.sleep(1000);
		add_subcategory_modal_popup_add_btn.click();
		Thread.sleep(1000);
		searchSubCategory();
		List<WebElement> subCategories=driver.findElements(By.xpath("//ul[@class='hidebullets']/li[@class='list_card']"));
		if(subCategories.size()==0) {
			Assert.assertTrue(false, sub_category_name+" subcategory does not find");
		}
		logger.info("==========Subcategory "+sub_category_name+ " is added========");
		subCategories.get(0).click();
	}
	public void searchSubCategory() throws InterruptedException {
		logger.info("==========Searching for "+sub_category_name+" sub category========");
		add_subcategory_search_field.sendKeys(sub_category_name);		
	}
	public void viewSubCategory() throws InterruptedException {
		logger.info("==========Viewing the "+sub_category_name+" sub category========");
		searchSubCategory();
		List<WebElement> categories=driver.findElements(By.xpath("//ul[@class='hidebullets']/li[@class='list_card']"));
		if(categories.size()>0) {
			subcategories_ellipsis_vertical_icon.click();
			Thread.sleep(2000);
			subcategories_view_icon.click();
			Thread.sleep(2000);
		}
		else {
			Assert.assertTrue(false, sub_category_name+" subcategory does not find");
		}
		Assert.assertTrue(view_dialogue_header.isDisplayed(),"You are not on view subcategory page");
		Thread.sleep(2000);
		
	}
	public void editSubCategory() throws InterruptedException {
		subCategory_newValue=sub_category_name+"_test123";
		logger.info("==========Searching the "+sub_category_name+" sub category========");
		searchSubCategory();
		Thread.sleep(2000);
		logger.info("==========Navigating to edit "+sub_category_name+" sub category========");
		List<WebElement> categories=driver.findElements(By.xpath("//ul[@class='hidebullets']/li[@class='list_card']"));
		if(categories.size()>0) {
			subcategories_ellipsis_vertical_icon.click();
			Thread.sleep(2000);
			subcategories_edit_icon.click();
			Thread.sleep(2000);
		}
		else {
			Assert.assertTrue(false, sub_category_name+" subcategory does not find");
		}
		Assert.assertTrue(edit_dialogue_header.isDisplayed(),"You are not on view subcategory page");
		edit_dialogue_subcat_name_field.clear();
		Thread.sleep(2000);
		edit_dialogue_subcat_name_field.sendKeys(subCategory_newValue);
		Thread.sleep(2000);
		edit_dialogue_subcat_update_btn.click();
		Thread.sleep(2000);
		add_subcategory_search_field.sendKeys(subCategory_newValue);
		Thread.sleep(2000);
		List<WebElement> subCategories=driver.findElements(By.xpath("//div[@class='col-3 white_panel'][2]//div//ul[@class='hidebullets']//li[@class=' list_card active_white']"));
		if(subCategories.size()==0) {
			Assert.assertTrue(false, subCategory_newValue+" subcategory does not find");
		}
		logger.info("==========Subcategory "+sub_category_name+ " is updated to " +subCategory_newValue+"========");
	}
	public void deleteSubCategory() throws InterruptedException {
		logger.info("==========Searching the "+subCategory_newValue+" sub category========");
		add_subcategory_search_field.sendKeys(subCategory_newValue);
		logger.info("==========Deleting "+subCategory_newValue+" sub category========");
		List<WebElement> categories=driver.findElements(By.xpath("//ul[@class='hidebullets']/li[@class='list_card']"));
		if(categories.size()>0) {
			subcategories_ellipsis_vertical_icon.click();
			Thread.sleep(2000);
			subcategories_delete_icon.click();
			Thread.sleep(2000);
		}
		else {
			Assert.assertTrue(false, subCategory_newValue+" subcategory does not find");
		}
		Assert.assertTrue(delete_dialogue_header_title.isDisplayed(),"You are not on delete confirmation dialogue");
		Thread.sleep(2000);
		delete_dialogue_subcat_delete_btn.click();
		Thread.sleep(2000);
		add_subcategory_search_field.sendKeys(subCategory_newValue);
		Thread.sleep(2000);
		List<WebElement> subCategories=driver.findElements(By.xpath("//div[@class='col-3 white_panel'][2]//div//ul[@class='hidebullets']//li[@class=' list_card active_white']"));
		System.out.println("Elements after deleting subcategory: "+subCategories.size());
		if(subCategories.size()>0) {
			Assert.assertTrue(false, subCategory_newValue+" subcategory is not deleted");
		}
		logger.info("==========Subcategory "+subCategory_newValue+ " is deleted========");
	}
	

}
