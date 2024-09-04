package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Configurations.loginutil;

public class Tabletspage extends loginutil{
	
	public static WebDriver driver;
	
	
  public Tabletspage(WebDriver driver) {
	  this.driver=driver;
  }
      
	  @FindBy(xpath="//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]")
	  WebElement tablets;
	  @FindBy(xpath="//h2[text()='Tablets']")
	  WebElement texttablts;
	  @FindBy(xpath="//img[@title='Samsung Galaxy Tab 10.1']")
	  WebElement clickonimagelink;
	  @FindBy(id="input-quantity")
	  WebElement quntity;
	  @FindBy(id="button-cart")
	  WebElement buttoncart;
	  @FindBy(xpath="//a[normalize-space()='shopping cart']")
	  WebElement clickonshoppingcart;
       @FindBy(xpath="//a[@class='btn btn-primary']")
       WebElement clickoncheckout;
	  
	  
	  public void tablets() throws Throwable {
		  Thread.sleep(3000);
		  tablets.click();
		  Thread.sleep(3000);
		  clickonimagelink.click();
		  Thread.sleep(2000);
		  quntity.clear();
		  quntity.sendKeys("8");
		  Thread.sleep(1000);
		  
		  buttoncart.click();
		  Thread.sleep(1000);
		  String Expected_Title="Samsung Galaxy Tab 10.1";
		  String Acutual_title = driver.getTitle();
		  Assert.assertEquals(Acutual_title, Expected_Title);
		  System.out.println(Expected_Title);
		  System.out.println(Acutual_title);
		  Thread.sleep(1000);
		  clickonshoppingcart.click();
		  Thread.sleep(1000);
		  clickoncheckout.click();
		  
		  
		  
		  
		  
		  
	  }
	  

	    
	    
	  
	  
	  
	  
	  
	
	
}


