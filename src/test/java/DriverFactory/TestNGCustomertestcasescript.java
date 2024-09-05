package DriverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Page.Customerpage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Config.ERP_app;
import ExcelFileUtil.Excelfileutil;


public class TestNGCustomertestcasescript extends ERP_app{
	
	
	
	String inputpath="C:\\Users\\DELL\\eclipse-workspace\\DataDrivenFramework\\FileInput\\customer.data.xlsx";
	String outputpath="C:\\Users\\DELL\\eclipse-workspace\\DataDrivenFramework\\FileOutput\\customerresults.xlsx";
	ExtentReports reports;
	
	ExtentTest logger;
	String sheet="Customer data";
	@Test
	public void starttest() throws Throwable {
		
		reports=new ExtentReports("./report/Custeomerdata.html");
		Excelfileutil xl=new Excelfileutil(inputpath);
		int rc =xl.rowcount(sheet);
		Reporter.log("no of rows::"+rc);
		for(int i=1;i<=rc;i++) {
			logger=reports.startTest("Add Custemer data");
			logger.assignAuthor("Sivamani");
			String cname=xl.getcellData(sheet, i, 0);
			String Adress=xl.getcellData(sheet, i, 1);
			String city=xl.getcellData(sheet, i, 2);
			String country=xl.getcellData(sheet, i, 3);
			String person=xl.getcellData(sheet, i, 4);
			String pnumber=xl.getcellData(sheet, i, 5);
			String emial=xl.getcellData(sheet, i, 6);
			String mnumber=xl.getcellData(sheet, i, 7);
			String notes=xl.getcellData(sheet, i, 8);
			Customerpage custpage=PageFactory.initElements(driver, Customerpage.class);
			boolean res = custpage.addcustomers(cname, Adress, city, country, person, pnumber, emial, mnumber, notes);
			logger.log(LogStatus.INFO,cname+"----"+Adress+"---"+city+"---"+country+"---"+person+"---"+pnumber+"--"+emial+"--"+mnumber+notes);
			if(res) {
				xl.setcellData(sheet, i, 9, "Pass", outputpath);
				logger.log(LogStatus.PASS, "customerdata added successfully");
			}
			else{
				xl.setcellData(sheet, i, 9, "Fail", outputpath);
				logger.log(LogStatus.FAIL,"customerdata added failed");
			}
		}
		
		
	}
	

}
