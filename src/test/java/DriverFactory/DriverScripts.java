package DriverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunctions.FunctionLibrary;
import Config.Apputil;
import ExcelFileUtil.Excelfileutil;

public class DriverScripts extends Apputil{
	
	
	String inputpath="C:\\Users\\DELL\\eclipse-workspace\\DataDrivenFramework\\FileInput\\Book.xlsx";
	String outputpath="C:\\Users\\DELL\\eclipse-workspace\\DataDrivenFramework\\FileOutput.xlsx";
	ExtentReports report;
	ExtentTest logger;
	@Test
	public void starttest() throws Throwable {	
		report= new ExtentReports("./report/login.html");
		
		
		Excelfileutil xl=new Excelfileutil(inputpath);
		int rc=xl.rowcount("Sheet1");
		Reporter.log("no of row are ::"+rc,true);
		for(int i=1;i<=rc;i++) {
			logger =report.startTest("ValidLogin");
			String Username=xl.getcellData("Sheet1", i, 0);
			String Password=xl.getcellData("Sheet1", i, 1);
			logger.log(LogStatus.INFO, Username+"========"+Password);
			boolean res = FunctionLibrary.adminlogin(Username, Password);
			if(res) {
				xl.setcellData("Sheet1", i, 2, "Valid username and password", outputpath);
				xl.setcellData("Sheet1", i, 3, "Pass",outputpath);
				logger.log(LogStatus.INFO, "login is successfull");
			}
			else {
				xl.setcellData("Sheet1", i, 2, "InValid username and Invalidpassword", outputpath);
				xl.setcellData("Sheet1", i, 3, "Fail",outputpath);
				logger.log(LogStatus.INFO, "login in failed");
			}
		}
			
		report.endTest(logger);
		report.flush();
			
			
		
			
		}
		
	}
	
	
	
	
	
	


