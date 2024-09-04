package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Page.Adminlogin;
import com.Page.Adminlogout;


public class ERP_app {
	public static WebDriver driver;
	public static Properties conpro;
	
	
	@BeforeTest
	public void setup() throws Throwable, Throwable {
		conpro=new Properties();
		conpro.load(new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\DataDrivenFramework\\PropertyFiles\\Envoronmental.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(conpro.getProperty("Browser").equalsIgnoreCase("Edge")) {
			driver=new FirefoxDriver();
		}
		
		
		else {
			Reporter.log("Brower is not Matching",true);
		}
		driver.get(conpro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		Adminlogin login=PageFactory.initElements(driver, Adminlogin.class);
		Thread.sleep(2000);
		login.verify_loginpage("admin","master");
		
		
		
		
	}
	
	@AfterTest
	public void teardown() throws Throwable {
		Adminlogout logout=PageFactory.initElements(driver, Adminlogout.class);
		Thread.sleep(2000);
		logout.verify_logout();
		driver.quit();
		
		
	}
	}


