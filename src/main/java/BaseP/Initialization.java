package BaseP;

import java.io.FileNotFoundException;

import org.testng.annotations.Parameters;

import Pages.LoginPage;
import Reports.ExtentReporterNG;

public class Initialization extends BaseClass {
	
	public static void setUp() throws FileNotFoundException, InterruptedException {
		
		System.out.println("in beforetest");
		
		BaseClass b = new BaseClass();
		
		LoginPage l = new LoginPage();
		l.browserInitialization("Chrome");
		Thread.sleep(3000);
		
		System.out.println("extent report-----------");
		
		LoginPage.launchUrl();
		LoginPage.appLogin();
 		ExtentReporterNG.extentReportMethod();		
		
}

}
