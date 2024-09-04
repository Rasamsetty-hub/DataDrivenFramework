package CommonFunctions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.page.Searchpage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Configurations.loginutil;
import ExcelFileUtil.Excelfileutil;

public class TestcaseSearch  extends loginutil{

	String inputpath="C:\\Users\\DELL\\eclipse-workspace\\Tutorialsninja\\FileInput\\Book1.xlsx";
	String Outputpath="C:\\Users\\DELL\\eclipse-workspace\\Tutorialsninja\\FileOutput.xlsx";
		
	ExtentReports reports;
	
	static ExtentTest logger;
	String sheet="search";
    @Test
	public void Starttest() throws Throwable {
    	reports=new ExtentReports("C:\\Users\\DELL\\eclipse-workspace\\Tutorialsninja\\report/logindata.html");
		logger=reports.startTest("Search credentials");
		Excelfileutil xl=new Excelfileutil(inputpath);
    	int rc=xl.rowcount(sheet);
    	Reporter.log("no of rows::"+rc);
    	for(int i=1;i<=rc;i++) {
    		String fanme=xl.getcellData(sheet, i, 0);
    		String lanme=xl.getcellData(sheet, i, 1);
    		String Email=xl.getcellData(sheet, i, 2);
    		String Telephone=xl.getcellData(sheet, i, 3);
    		String password=xl.getcellData(sheet, i, 4);
    		String confirmpassword=xl.getcellData(sheet, i, 5);
    		Searchpage spage=PageFactory.initElements(driver, Searchpage.class);
    		boolean res = spage.addsearchdata(fanme, lanme, Email, Telephone, password, confirmpassword);
    		if(res) {
    			xl.setcellData(sheet, i, 6, "pass",Outputpath );
    			}
    		else {
    			xl.setcellData(sheet, i, 6, "fail", Outputpath);
    		}
    	}
    		
    	}

}
