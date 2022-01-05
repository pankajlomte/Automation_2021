package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;


//import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseP.BaseClass;
import BaseP.Initialization;
//import Logs.logsClass;
import Pages.LoginPage;
import Pages.ManageEmployees;
import Reports.ExtentReporterNG;
import Reports.createPDFReport;
 


public class verifyUser extends BaseClass{
	
	createPDFReport cpdf = new createPDFReport();
	ManageEmployees me = new ManageEmployees();
	
	@BeforeTest
	 public void initializationM2() {
		
		try {
			Initialization.setUp();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void confirmUsername() throws IOException, InterruptedException {
		

		ManageEmployees m = new ManageEmployees();
		System.out.println("In Confirmusername test");
		
		ExtentReporterNG.test = ExtentReporterNG.extent.createTest("verify user test casessssssssss 1","1512");
		ExtentReporterNG.test.log(Status.INFO, "THIS IS THE LOG FROM EXTENT REPORT ");
		
		explicitWait(m.userProfile, 15);
		m.checkUserprofile(); 
 
	}
	
	@Test(priority=2)
	public void checkReport() {
		
		System.out.println("Second Test case - checkReport");
		
		ExtentReporterNG.test = ExtentReporterNG.extent.createTest("second test is ------- checkReport");
		
		try {
				System.out.println("value is -----"+(1/0));
		}
		
		catch (Exception e) {
			ExtentReporterNG.test.log(Status.INFO, "FAILED DUE TO INFINITY RESULT");
			
			ExtentReporterNG.test.log(Status.FAIL, "FAILED DUE TO INFINITY RESULT---STATUS");
		}
		
		
	}
	
	@Test(priority=3)
	public void checkUserData() {
		
		me.checkRolesInfo();
		
		
		
		
	}
	
	@AfterTest
	public void finishTest1() {
		closeBrowser();
		ExtentReporterNG.extent.flush();
	}
	
}
