package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;


//import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseP.BaseClass;
//import Logs.logsClass;
import Pages.LoginPage;
import Pages.ManageEmployees;
import Reports.ExtentReporterNG;
import Reports.createPDFReport;
 


public class verifyUser extends BaseClass{
	
	createPDFReport cpdf = new createPDFReport();
	
	
	@BeforeTest
	public void setUp() throws FileNotFoundException, InterruptedException {
		
		System.out.println("in beforetest");
		 
		LoginPage l = new LoginPage();
		l.browserInitialization("chrome");
		Thread.sleep(3000);
		
		System.out.println("extent report-----------");
		
		LoginPage.launchUrl();
		LoginPage.appLogin();
		//Thread.sleep(5000);
		//explicitWait(m.userProfile, 20);
		ExtentReporterNG.extentReportMethod();
		
		
		
}
	
	@Test(priority=1)
	public void confirmUsername() throws IOException, InterruptedException {
		

		ManageEmployees m = new ManageEmployees();
		System.out.println("In Confirmusername test");
		
		ExtentReporterNG.test = ExtentReporterNG.extent.createTest("verify user test casessssssssss 1","1512");
		ExtentReporterNG.test.log(Status.INFO, "THIS IS THE LOG FROM EXTENT REPORT ");
		
		 
		//extentReportsClass.test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\src\\main\\resources\\Screenshots\\extentTEST.png");
		 
		explicitWait(m.userProfile, 15);
		m.checkUserprofile(); 
		
	/*	logsClass.logging();
		
		logsClass.logs.info("logs info---------------------------------------------");
		logsClass.logs.debug("DEBUD --- CONFIRMUSER");
		logsClass.logs.fatal("FATAL --- CONFIRMUSER");
		logsClass.logs.error("Error ------ confirmuser");
		logsClass.logs.warn("warn ----- confirmuser");
	*/
		
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
	public static void checkUserData() {
		
	}
	
	@AfterTest
	public void finishTest1() {
		closeBrowser();
		ExtentReporterNG.extent.flush();
	}
	
}
