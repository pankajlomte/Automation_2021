package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Base.BaseClass;
import Utilities.readExcel;

public class ManageEmployees extends BaseClass {
	
	
	
	@FindBy(xpath="//span[@class='uname-top']")
	public static WebElement userProfile;
	
	public static void checkUserprofile() {
		
		try {
			readExcel.getTestData();
			
			 String expectedProfileName= readExcel.firstName+" "+readExcel.lastName;
			 
			 String actualProfileName=userProfile.getText();
			 
			 System.out.println("Now check the user on right corner-------");
			 
			 Assert.assertTrue(actualProfileName.contains(expectedProfileName), "User is correct"); 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	

}
