package com.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Customerpage {
	
	WebDriver driver;
	public Customerpage(WebDriver driver) {
		this.driver=driver;
		
		}
	@FindBy(xpath="//li[@id='mi_a_customers']//a[@href='a_customerslist.php'][normalize-space()='Customers']")
	WebElement customerlink;
	@FindBy(xpath="//div[@class='panel-heading ewGridUpperPanel']//span[@class='glyphicon glyphicon-plus ewIcon']")
	WebElement clickaddiconbutton;
	@FindBy(id="x_Customer_Number")
	WebElement customernumber;
	@FindBy(name="x_Customer_Name")
	WebElement entercustomername;
	@FindBy(name="x_Address")
	WebElement enterAddress;
	@FindBy(name="x_City")
	WebElement entercity;
	@FindBy(name="x_Country")
	WebElement entercountry;
	@FindBy(name="x_Contact_Person")
	WebElement enterperson;
	@FindBy(name="x_Phone_Number")
	WebElement enterphonenumber;
	@FindBy(name="x__Email")
	WebElement enteremail;
	@FindBy(name="x_Mobile_Number")
	WebElement entermobilenumber;
	@FindBy(name="x_Notes")
	WebElement enternotes;
	@FindBy(id="btnAction")
	WebElement addbutton;
	@FindBy(xpath="//button[text()='OK!']")
	WebElement confirmokbuttonofaddnewrecord;
	@FindBy(xpath="//button[@class='ajs-button btn btn-primary']")
	WebElement addsucesssokbutton;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-search ewIcon']")
	WebElement clickonsearchpanelbutton;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement entersearchbox;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement clickonsearchbutton;
	
	@FindBy(xpath="//span[@id='el1_a_customers_Customer_Number'] ")
	WebElement webtable;
	
	public boolean addcustomers(String cname,String Adress,String city,String Country,String cperson,String pnumber,String email,String mnumber,String Notes) throws Throwable{ {
		Actions ac=new Actions(driver);
		ac.moveToElement(customerlink).click().perform();
		Thread.sleep(2000);
		ac.moveToElement(clickaddiconbutton).click().perform();
		String Exp_Data=customernumber.getAttribute("value");
		entercustomername.sendKeys(cname);
		enterAddress.sendKeys(Adress);
		entercity.sendKeys(city);
		entercountry.sendKeys(Country);
		enterperson.sendKeys(cperson);
		enterphonenumber.sendKeys(cperson);
		enteremail.sendKeys(email);
		entermobilenumber.sendKeys(mnumber);
		enternotes.sendKeys(Notes);
		addbutton.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ac.moveToElement(confirmokbuttonofaddnewrecord).click().perform();
		Thread.sleep(2000);
		ac.pause(3000);
		ac.moveToElement(addsucesssokbutton).click().perform();
		Thread.sleep(3000);
		if(!entersearchbox.isDisplayed())
			clickonsearchpanelbutton.click();
		entersearchbox.clear();
		entersearchbox.sendKeys(Exp_Data);
		clickonsearchbutton.click();
		Thread.sleep(2000);
		String Act_Data=webtable.getText();
		if(Act_Data.equalsIgnoreCase(Exp_Data)) {
			Reporter.log(Act_Data+"--------"+Exp_Data,true);
			return true;
		}
			else {
				
				Reporter.log(Act_Data+"--------"+Exp_Data,true);
				return false;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
	}
	
	

