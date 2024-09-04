package CommonFunctions;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.page.Tabletspage;

import Configurations.loginutil;

public class Testcasetablets extends loginutil {
	@Test
	public void tabwebpage() throws Throwable {
		
		//Tabletspage tpage=PageFactory.initElements(driver, Tabletspage.class);
		Tabletspage lp=PageFactory.initElements(driver, Tabletspage.class);
		lp.tablets();
	
	    
		
	}
	
	
	

}
