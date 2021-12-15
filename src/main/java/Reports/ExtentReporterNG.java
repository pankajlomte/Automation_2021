package Reports;

import org.testng.IReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseP.BaseClass;


public class ExtentReporterNG extends BaseClass implements IReporter   {
	
	
	public static ExtentTest test;
	public static ExtentReports extent;
	
	public static void extentReportMethod() {
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		 
	}
	
	

}
