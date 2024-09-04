package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.loginutil;

public class Cameraspage extends loginutil {
	
	public WebDriver driver;
	
	public Cameraspage(WebDriver driver) {
		this.driver=driver;
	}
	
    @FindBy(xpath="//li[7]//a[1]")
    WebElement cameras;
    
    @FindBy(xpath="//img[@title='Nikon D300']")
    WebElement imagecamera;
    
    @FindBy(xpath="//li[3]//a[1]//img[1]")
    WebElement frontcamera;
    
    @FindBy(xpath="//button[@title='Next (Right arrow key)']")
    WebElement movetootherone;
    @FindBy(xpath="//img[@class='mfp-img']")
    WebElement movetoup;
    @FindBy(xpath="//input[@id='input-quantity']")
    WebElement quantity;
    @FindBy(id="button-cart")
    WebElement addtocart;
    
   // String Expected_title="Success: You have added Nikon D300 to your shopping cart!";
  // String Actual_Title=driver.getTitle();
    @FindBy(xpath="//a[normalize-space()='shopping cart']")
    WebElement shoppingcart;
    @FindBy(xpath="//a[@class='btn btn-primary']")
    WebElement checkout;
    
    public void verify_camera_page() throws Throwable {
    	cameras.click();
    	Thread.sleep(1000);
    	imagecamera.click();
    	Thread.sleep(1000);
    	quantity.clear();
    	Thread.sleep(1000);
    	addtocart.click();
    	Thread.sleep(1000);
    	shoppingcart.click();
    	Thread.sleep(1000);
    	checkout.click();
    	
    
    	
    	
    	
    	
    	
    	
    }
    
    
	
	
	
}
