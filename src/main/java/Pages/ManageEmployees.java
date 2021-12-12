package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Base.BaseClass;
import Utilities.readExcel;
import Utilities.readExcelAdvanced;

public class ManageEmployees extends BaseClass {
	
	
	
	@FindBy(xpath="//span[@class='uname-top']")
	public WebElement userProfile;
	
	public void checkUserprofile() {
		
		ManageEmployees me= new ManageEmployees();
		
			 //readExcel.getTestData();
			firstName = readExcelAdvanced.getData("Firstname", 1);
			lastName = readExcelAdvanced.getData("lastName", 1);
			
			 String expectedProfileName= firstName+" "+lastName;
			 
			 explicitWait(userProfile,20);
			 
			 String actualProfileName=me.userProfile.getText();
			 
			 System.out.println("Now check the user on right corner-------");
			 
			 Assert.assertTrue(actualProfileName.contains(expectedProfileName), "User is correct"); 
			
		 
	}
	
		
	

}
