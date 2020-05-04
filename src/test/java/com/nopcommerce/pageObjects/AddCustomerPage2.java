package com.nopcommerce.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage2 extends BasicClass {
	
//	public WebDriver driver;
	
	public AddCustomerPage2(WebDriver driver)
	{
		super(driver);
	}
	
	String lnkCustomers_menu="xpath|//a[@href='#']//span[contains(text(),'Customers')]";
	String lnkCustomers_menuitem="xpath|//span[@class='menu-item-title'][contains(text(),'Customers')]";
	
	String btnAddnew="xpath|//a[@class='btn bg-blue']"; //Add new
		
	String txtEmail="xpath|//input[@id='Email']";
	String txtPassword="xpath|//input[@id='Password']";
	
	String txtcustomerRoles="xpath|//div[@class='k-multiselect-wrap k-floatwrap']";
	
	String lstitemRemove = "xpath|//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]";
//	String lstitemAdministrators="xpath|//li[contains(text(),'Administrators')]";
//	String lstitemRegistered="xpath|//li[contains(text(),'Registered')]";
//	String lstitemGuests="xpath|//li[contains(text(),'Guests')]";
//	String lstitemVendors="xpath|//li[contains(text(),'Vendors')]";
//	
	
	String drpmgrOfVendor="xpath|//*[@id='VendorId']";
	String rdMaleGender="id|Gender_Male";
	String rdFeMaleGender="id|Gender_Female";
	
	String txtFirstName="xpath|//input[@id='FirstName']";
	String txtLastName="xpath|//input[@id='LastName']";
	
	String txtDob="xpath|//input[@id='DateOfBirth']";
	
	String txtCompanyName="xpath|//input[@id='Company']";
		
	String txtAdminContent="xpath|//textarea[@id='AdminComment']";
	
    String btnSave="xpath|//button[@name='save']";
	
	
	public void clickOnCustomersMenu() {
		clickOnElement(lnkCustomers_menu);
	}

	public void clickOnCustomersMenuItem() {
		clickOnElement(lnkCustomers_menuitem);
	}
	
	public void clickOnAddnew() {
		clickOnElement(btnAddnew);
	}
	
	public void setEmail(String email) throws InterruptedException
	{
		enterDataInTextField(txtEmail, email);
	}
	
	public void setPassword(String password) throws InterruptedException
	{
		enterDataInTextField(txtPassword, password);
	}
	
	
	public void setCustomerRoles(String[] role) throws InterruptedException 
		{
			clickOnElement(lstitemRemove);	
			clickOnElement(txtcustomerRoles);
			for(int i = 0; i < role.length;i++ ) {
				String lstrole="xpath|//li[contains(text(),"+"'"+role[i]+"'"+")]";
//				System.out.print(lstrole);
//				Thread.sleep(3000);
				clickonElementJavaScript(lstrole);
				if(i > 0) {
					clickOnElement(txtcustomerRoles);
				}
			}

			
	}

	public void setManagerOfVendor(String value)
	{
		setManagerOfVendor(drpmgrOfVendor, value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			clickOnElement(rdMaleGender);
		}
		else if(gender.equals("Female"))
		{
			clickOnElement(rdFeMaleGender);
		}
		else
		{
			
			clickOnElement(rdFeMaleGender);
		}
		
	}
	
	public void setFirstName(String fname) throws InterruptedException
	{
		enterDataInTextField(txtFirstName, fname);
	}
	
	public void setLastName(String lname) throws InterruptedException
	{
		enterDataInTextField(txtPassword, password);
	}
	
	public void setDob(String dob) throws InterruptedException
	{
		enterDataInTextField(txtDob, dob);
	}
	
	public void setCompanyName(String comname) throws InterruptedException
	{
		enterDataInTextField(txtCompanyName, comname);
	}
	
	public void setAdminContent(String content) throws InterruptedException
	{
		enterDataInTextField(txtAdminContent, content);
	}
	
	public void clickOnSave()
	{
		clickOnElement(btnSave);
	}
}