package Pages;

//import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseP.BaseClass;
import UtilitiesP.readExcelAdvanced;

public class ManageEmployees extends BaseClass {
	
	
	
	@FindBy(xpath="//span[@class='uname-top']")
	public WebElement userProfile;
	
	@FindBy(xpath="//a/span")
	public WebElement rolesInfoIcon;
	
	@FindBy(xpath="//div[text()='Roles Info']")
	public WebElement rolesInfo;
	
	@FindBy(xpath="//span[@title='Apply Filter']//*[name()='svg']")
	public WebElement employeeFilter;
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement searchPlaceholder;
	
	@FindBy(xpath="//ul[@xpath=1]")
	public WebElement popupContent;
	
	public ManageEmployees() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkUserprofile() throws InterruptedException {
		
		ManageEmployees me= new ManageEmployees();
		
			 //readExcel.getTestData();
		
			firstName = readExcelAdvanced.getData("Firstname", 1);
			lastName = readExcelAdvanced.getData("Lastname", 1);
			
			 String expectedProfileName= firstName+" "+lastName;
			 
			  explicitWait(userProfile,5);
			 
			 String actualProfileName=me.userProfile.getText().replaceAll("\n","");
			 
			 System.out.println("Now check the user on right corner-------");
			 
			 Assert.assertTrue(actualProfileName.contains(expectedProfileName), "User is NOT correct"); 	
	}
	
	public void checkRolesInfo() {
		
		rolesInfoIcon.click();
		
		explicitWait(rolesInfo,5);
		
		System.out.println("Popup title is "+rolesInfo.getText());
		
		System.out.println("Below is role information: ");
		
		System.out.println(popupContent.getText());

	}
	
	
	
		
	

}
