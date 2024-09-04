package Configurations;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.page.Cameraspage;



public class loginutil {
	
	public static WebDriver driver;
	public static Properties conpro;
	
	
	@BeforeTest
	public void logintest() throws Throwable, Throwable {
		conpro=new Properties();
		conpro.load(new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Tutorialsninja\\PropertyFiles\\Environmental.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
			
			
		}
			else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
				}
			else {
				Reporter.log("Browser is not matching",true);
			}
		driver.get(conpro.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//Loginpage lpage=PageFactory.initElements(driver, Loginpage.class);
		//Cameraspage cpage=new Cameraspage(WebDriver driver);
		
		
		
		
		
		
				
			}
			@AfterTest
			public void tearDown() {
				driver.quit();
			}
			
			
		
	}

