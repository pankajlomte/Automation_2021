package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	public static Properties prop;
	public static WebDriver driver;
	public  String browser;
	public WebDriverWait wait;
	
	public static Logger log = LogManager.getLogger(BaseClass.class);
	
	public static void LoadProperty() {
		
		try { 
			
			System.out.println(log.isInfoEnabled());
			
		 prop = new Properties(); //Creates an empty property list with no default values.
		
		InputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Properties\\config.properties");

		prop.load(fis); // Currently it only contains URL parameter.
		
		log.info("Started loading the properties file");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		@Parameters("browser") // Instead of properties file,  configured browsers in testng.xml
		public  void browserInitialization (String browser) {
			
			this.browser = browser;
			
		      if(browser.equalsIgnoreCase("chrome")) {
				
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
		    	  			    	
			ChromeOptions co = new ChromeOptions();
			
			co.setAcceptInsecureCerts(true);
			
			driver = new ChromeDriver(co);
				
			log.info("Initialiazing the Chrome Browser");

				
		}else if (browser.equalsIgnoreCase("firefox")) {
			
				System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\geckodriver.exe");
			
				driver = new FirefoxDriver();
				
				log.info("Initializing the Firefox browser");
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		
	}
		public static void closeBrowser() {
			
			System.out.println("Closing the browser");
			log.info("Closing browser");
			driver.quit();
		}
		
		public static void explicitWait(WebElement element) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			wait.until(ExpectedConditions.visibilityOf(element));
			
			System.out.println("waiting 20 seconds for -----"+element);
			
			log.info("Explicitly waiting for 20 seconds max");
		}
		  	
}
