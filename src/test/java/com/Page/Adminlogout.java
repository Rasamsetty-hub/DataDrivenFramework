package com.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Adminlogout {
	@FindBy(xpath = "//a[@id='logout']")
	WebElement logout;
	
	public void verify_logout() throws Throwable {
		Thread.sleep(2000);
		logout.click();
	}

}
