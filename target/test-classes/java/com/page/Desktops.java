package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Configurations.loginutil;

public class Desktops extends loginutil  {
	
WebDriver driver;
	
	
	public Desktops(WebDriver driver) {
		this.driver=driver;		
		}

	@FindBy(xpath="//a[@class='dropdown-toggle' and text()='Desktops']")
	WebElement desktops;
	@FindBy(xpath="//a[normalize-space()='Mac (1)']")
	WebElement clickonmac;
	@FindBy(xpath="//span[normalize-space()='Add to Cart']")
	WebElement clickonaddcart;
	
	
	
	public void mac() throws Throwable {
		desktops.click();
		Thread.sleep(3000);
		clickonmac.click();
		Thread.sleep(3000);
		clickonaddcart.click();
		
	}
	
}
