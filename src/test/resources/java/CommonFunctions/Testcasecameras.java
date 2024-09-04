package CommonFunctions;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.page.Cameraspage;
import com.page.Searchpage;

import Configurations.loginutil;

public class Testcasecameras extends loginutil {
	@Test
	public void excecute() throws Throwable {
		//Cameraspage amp=PageFactory.initElements(driver, Cameraspage.class);
		//Cameraspage spage=PageFactory.initElements(driver, Cameraspage.class);
		Cameraspage cpage=PageFactory.initElements(driver, Cameraspage.class);
		
		cpage.verify_camera_page();
	}

}
