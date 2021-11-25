package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportsClass {
	
	
	public static ExtentTest test;
	public static ExtentReports extent;
	
	public static void extentReportMethod() {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
	}
	
	

}
