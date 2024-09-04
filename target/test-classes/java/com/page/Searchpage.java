package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import Configurations.loginutil;

public class Searchpage extends loginutil {
	
	WebDriver driver;
	public Searchpage(WebDriver driver) {
		this.driver=driver;
		}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccountpage;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement clickregisterpage;
	
	@FindBy(id="input-firstname")
	WebElement firstname;
	
	@FindBy(id="input-lastname")
	WebElement lastname;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement Password;
	@FindBy(id="input-confirm")
	WebElement confrimpassword;
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement newletter;
	@FindBy(xpath="//input[@name='agree']")
	WebElement privatepolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebutton;
	
	public boolean addsearchdata(String Fname,String lname, String Email,String Telephone,String password,String confirmPassword) throws Throwable {	
		myaccountpage.click();
		Thread.sleep(3000);
		clickregisterpage.click();
		Thread.sleep(3000);
		firstname.sendKeys(Fname);
		lastname.sendKeys(lname);
		email.sendKeys(Email);
		telephone.sendKeys(Telephone);
		Password.sendKeys(password);
		confrimpassword.sendKeys(confirmPassword);
	String Expected_title="Register Account";
	String Actual_title = driver.getTitle();
	Assert.assertEquals(Actual_title, Expected_title);
	return true;
	
		
		
		
		
		
		
		
	}
	
	
	

}
