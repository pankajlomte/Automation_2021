package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	public static Properties prop;
	public static WebDriver driver;
	public  String browser;
	
	public static void LoadProperty() {
		
		try {
			
		 prop = new Properties(); //Creates an empty property list with no default values.
		
		InputStream fis = new FileInputStream("D:\\Automation\\AnonyMoose\\src\\main\\resources\\Properties\\config.properties");

		prop.load(fis); // Currently it only contains URL parameter.
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		@Parameters("browser") // Instead of properties file,  configured browsers in testng.xml
		public  void browserInitialization (String browser) {
			
			this.browser = browser;
			
		      if(browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "D:\\Automation\\AnonyMoose\\src\\main\\resources\\Drivers\\chromedriver.exe");
				
				driver = new ChromeDriver();
				
		}else if (browser.equalsIgnoreCase("firefox")) {
			
				System.setProperty("webdriver.firefox.driver", "D:\\Automation\\AnonyMoose\\src\\main\\resources\\Drivers\\geckodriver.exe");
			
				driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();			
		
	}
		
		public static void wait(time)
		WebDriverWait 
		
		
		public static void closeBrowser() {
			
			System.out.println("Closing the browser");
			
			driver.quit();
		}
	
}
