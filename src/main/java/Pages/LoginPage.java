package Pages;

import java.io.FileNotFoundException;

//import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;
import Utilities.Screenshot;
import Utilities.readExcel;
import Utilities.readExcelAdvanced;

public class LoginPage extends BaseClass {
	
	 @FindBy(id="basic_email")
	 public WebElement user;
	 
	 @FindBy(id="basic_password")
	 public  WebElement pass;
	 
	 @FindBy(xpath="//span[contains(text(),'Sign In')]")
	 public  WebElement loginButton;
	 
	 public LoginPage() {
		 PageFactory.initElements(driver, this);// As initElements(SearchContext, Class) but will only replace the fields of an already instantiated Page Object.
		 //searchContext: The driver that will be used to look up the elements
	 }
	 
	 
	 public static void launchUrl() {
		 
		 BaseClass.LoadProperty();
		 
		 System.out.println("url is ------------"+prop.getProperty("url"));
		 
		 BaseClass.driver.get(prop.getProperty("url"));
		 
		 
	 }
	 
	 public static void appLogin() {
		 
		 LoginPage lp =  new LoginPage();
		
		readExcelAdvanced.setExcelfile(userDir+prop.getProperty("testDatafilePath"),"Sheet1");
		
		//readExcel.getTestData();
		
		userName=readExcelAdvanced.getData("Username",1);
		passWord=readExcelAdvanced.getData("Password",1);

		lp.user.sendKeys(readExcel.userName);
		lp.pass.sendKeys(readExcel.passWord);
		 
		lp.loginButton.click();
		
		explicitWait(lp.loginButton,5);
		
		Screenshot.getScreenshot("loginpageimage");
 
	 }
	

}
