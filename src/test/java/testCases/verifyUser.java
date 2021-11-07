package testCases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;

public class verifyUser extends BaseClass {
	
	
	@BeforeTest
	public void setUp() throws FileNotFoundException, InterruptedException {
		
		System.out.println("in beforetest");
		
		LoginPage l = new LoginPage();
		l.browserInitialization("chrome");
		Thread.sleep(3000);
		LoginPage.launchUrl();
		LoginPage.appLogin();
		//System.out.println(prop.getProperty("url"));
	}
	
	
	@Test
	public void confirmUsername() {
		
		System.out.println("in test");
		 
	}
	
	@AfterTest
	public void finishTest1() {
		closeBrowser();
	}
	
}
