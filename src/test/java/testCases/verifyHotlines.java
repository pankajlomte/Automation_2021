package testCases;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseP.BaseClass;
import BaseP.Initialization;
import Pages.LoginPage;
import Reports.ExtentReporterNG;

public class verifyHotlines extends BaseClass {
	
	@BeforeTest
			
		public void initializationMethod() {
			
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
		
	
	
	@Test
	public static void verifyHotlineDashboard() {
		
			
		
		
		
	}
	
	
	
	
	

}
