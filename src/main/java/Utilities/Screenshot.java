package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.BaseClass;

public class Screenshot extends BaseClass {
	
	public static void getScreenshot(String fileName) {
		
		
		TakesScreenshot srcshort = ((TakesScreenshot) driver);
		
		File file = srcshort.getScreenshotAs(OutputType.FILE);
		
		String Screenshotlocation = prop.getProperty(System.getProperty("user.dir")+"screenShotfilePath");
		
		System.out.println("system dir is -------- "+System.getProperty("user.dir"));
		
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		
		Date date = new Date();
		
		File destFile = new File(Screenshotlocation+fileName+df.format(date)+".png");
		
		try {
			
			FileHandler.copy(file, destFile);
			
			System.out.println("Copied the image to destination");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
