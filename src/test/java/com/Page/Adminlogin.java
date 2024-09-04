package com.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;




public class Adminlogin {
	WebDriver driver;
	public Adminlogin(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(id="btnreset")
	WebElement objresetbutton;
	 @FindBy(id="username")
		WebElement objuser;
	 @FindBy(xpath="//input[@id='password']")
	 WebElement objpass;
	 @FindBy(id="btnsubmit")
	 WebElement objlogin;
	 
	 public void verify_loginpage(String user,String pass) throws Throwable {
		 Thread.sleep(1000);
		 objresetbutton.click();
		 
		 objuser.sendKeys(user);
		 Thread.sleep(1000);
		 objpass.sendKeys(pass);
		 
		 Thread.sleep(1000);
		 objlogin.click();
		 String Expected="dashboard";
		 String Actual =driver.getCurrentUrl();
		 try {
		 Assert.assertTrue(Actual.contains(Expected), "Invalid username and Invalid Password");
		 }
		 catch(AssertionError e) {
			 System.out.println(e.getMessage());
			 
			 
		 
	 }
	
	 }
}
