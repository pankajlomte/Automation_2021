package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.BaseClass;
//import Logs.logsClass;
import Pages.LoginPage;
import Pages.ManageEmployees;
import Reports.extentReportsClass;


public class verifyUser extends BaseClass {
	
	LoginPage l = new LoginPage();
	
	ManageEmployees m = new ManageEmployees();
	
	@BeforeTest
	public void setUp() throws FileNotFoundException, InterruptedException {
		
		System.out.println("in beforetest");
		
		
		l.browserInitialization("chrome");
		Thread.sleep(3000);
		
		System.out.println("extent report-----------");
		
		LoginPage.launchUrl();
		LoginPage.appLogin();
		
		extentReportsClass.extentReportMethod();
		
		
}
	
	
	@Test
	public void confirmUsername() throws IOException, InterruptedException {
		
		
		System.out.println("In Confirmusername test");
		
		extentReportsClass.test = extentReportsClass.extent.createTest("verify user test case 1","1st desc");
		extentReportsClass.test.log(Status.INFO, "THIS IS THE LOG FROM EXTENT REPORT ");
		
		//explicitWait(ManageEmployees.userProfile);
		
		extentReportsClass.test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\src\\main\\resources\\Screenshots\\extentTEST.png");
		
		m.checkUserprofile(); 
		
	/*	logsClass.logging();
		
		logsClass.logs.info("logs info---------------------------------------------");
		logsClass.logs.debug("DEBUD --- CONFIRMUSER");
		logsClass.logs.fatal("FATAL --- CONFIRMUSER");
		logsClass.logs.error("Error ------ confirmuser");
		logsClass.logs.warn("warn ----- confirmuser");
	*/
		
	}
	
	@Test
	public void checkReport() {
		
		System.out.println("Second Test case - checkReport");
		
		extentReportsClass.test = extentReportsClass.extent.createTest("second test is ------- checkReport");
		
		try {
				System.out.println("value is -----"+(1/0));
		}
		
		catch (Exception e) {
			extentReportsClass.test.log(Status.INFO, "FAILED DUE TO INFINITY RESULT");
			
			extentReportsClass.test.log(Status.FAIL, "FAILED DUE TO INFINITY RESULT---STATUS");
		}
		
		
	}
	
	@AfterTest
	public void finishTest1() {
		closeBrowser();
		extentReportsClass.extent.flush();
	}
	
}
