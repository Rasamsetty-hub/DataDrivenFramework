package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;		
		}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement clicklogin;
	@FindBy(id="input-email")
	WebElement emailadress;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbutton;
	
	public boolean verify_Login_page(String Email, String Pass) {
		myaccount.click();
		clicklogin.click();
		emailadress.sendKeys(Email);
		password.sendKeys(Pass);
		loginbutton.click();
		return true;
		
		
		
		
		
	}
	

}
