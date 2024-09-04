package CommonFunctions;



import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Reporter;

import Config.Apputil;

public class FunctionLibrary extends Apputil {
	public static boolean adminlogin(String username,String Password) throws Throwable {
		driver.get(conpro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(conpro.getProperty("objreset"))).click();
		driver.findElement(By.xpath(conpro.getProperty("objusername"))).sendKeys(username);
		driver.findElement(By.xpath(conpro.getProperty("objpassword"))).sendKeys(Password);
		driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();
		Thread.sleep(3000);
		
	    String expected="dashboard";
	    String Actual =driver.getCurrentUrl();
	    if(Actual.contains(expected)) {
	    	Reporter.log("valid username and password ::"+expected+"---------"+Actual,true);
	    	System.out.println("dfgh");
	    	driver.findElement(By.xpath(conpro.getProperty("objlogout"))).click();
	    return true;
	    }
	    else {
	    	String message=driver.findElement(By.xpath(conpro.getProperty("objerror"))).getText();
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath(conpro.getProperty("objokbutton"))).click();
	    	Reporter.log(message+"----------"+expected+"---------"+Actual,true );
	    	
	    	return false;
	    }
	
	}
	
}
