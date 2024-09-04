package Config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Apputil {
	
	public static WebDriver driver;
	public static Properties conpro;
	FileInputStream fi;
	
	
	@BeforeTest
	
	public static void setup() throws Throwable {
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
			
	}
	@AfterTest
	public static void teardown() {
		driver.close();
	}

}
