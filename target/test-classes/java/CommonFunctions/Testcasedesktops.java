package CommonFunctions;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.page.Desktops;

import Configurations.loginutil;

public class Testcasedesktops extends loginutil {
	@Test
	public void startrun() throws Throwable {
		Desktops desc=PageFactory.initElements(driver, Desktops.class);
		desc.mac();
		driver.quit();
	}

}
