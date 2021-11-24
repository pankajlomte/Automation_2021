package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.BaseClass;
import Pages.LoginPage;

public class verifyUser extends BaseClass {
	
	public static ExtentTest test;
	public static ExtentReports extent;
	
	@BeforeTest
	public void setUp() throws FileNotFoundException, InterruptedException {
		
		System.out.println("in beforetest");
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		
		 extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		 
		LoginPage l = new LoginPage();
		l.browserInitialization("chrome");
		Thread.sleep(3000);
		
		System.out.println("extent report-----------");
		
		LoginPage.launchUrl();
		LoginPage.appLogin();
		//System.out.println(prop.getProperty("url"));
	}
	
	
	@Test
	public void confirmUsername() throws IOException {
		
		System.out.println("in test");
		
		test = extent.createTest("verify user test case 1","1st desc");
		test.log(Status.INFO, "THIS IS THE LOG FROM EXTENT REPORT ");
		test.addScreenCaptureFromPath("D:\\Automation\\AnonyMoose\\src\\main\\resources\\Screenshots\\extentTEST.png");
		 
	}
	
	@Test
	public void checkReport() {
		System.out.println("Second Test case - checkReport");
		test = extent.createTest("second test is ------- checkReport");
		try {
		System.out.println("value is -----"+(1/0));
		}
		
		catch (Exception e) {
			test.log(Status.INFO, "FAILED DUE TO INFINITY RESULT");
			
			test.log(Status.FAIL, "FAILED DUE TO INFINITY RESULT---STATUS");
		}
		
		
	}
	
	@AfterTest
	public void finishTest1() {
		closeBrowser();
		extent.flush();
	}
	
}
