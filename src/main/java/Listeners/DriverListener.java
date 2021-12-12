package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import Base.BaseClass;

public class DriverListener extends BaseClass implements WebDriverListener  {
	
	EventFiringDecorator ef = new EventFiringDecorator();

// This decorator creates a wrapper around an arbitrary WebDriver instance that notifies registered listeners about events happening in this WebDriver 
// and derived objects, such as WebElements and Alert. 

	public void beforeAlertAccept(WebDriver driver) {
		
		System.out.println("beforeAlertAccept method");
		
	}

	public void afterAlertAccept(WebDriver driver) {

		System.out.println("afterAlertAccept method");
		
	}

	public void afterAlertDismiss(WebDriver driver) {

		System.out.println("afterAlertDismiss method");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		
		System.out.println("beforeAlertAccept method");
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {

		System.out.println("beforeNavigateTo method");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		
		System.out.println("afterNavigateTo method");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		
		System.out.println("beforeNavigateBack method");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		
		System.out.println("afterNavigateBack method");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		
		System.out.println("beforeNavigateForward method");
		
	}

	public void afterNavigateForward(WebDriver driver) {

		System.out.println("afterNavigateForward method");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		
		System.out.println("beforeNavigateRefresh method");
		
	}

	public void afterNavigateRefresh(WebDriver driver) {

		System.out.println("afterNavigateRefresh method");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("beforeFindBy method");		
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("afterFindBy method");
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {

		System.out.println("beforeClickOn method");
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("afterClickOn method");
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		System.out.println("beforeChangeValueOf method");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		System.out.println("afterChangeValueOf method");
		
	}

	public void beforeScript(String script, WebDriver driver) {

		System.out.println("beforeScript method");
		
	}

	public void afterScript(String script, WebDriver driver) {

		System.out.println("afterScript method");
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		System.out.println("beforeSwitchToWindow method");
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {

		System.out.println("afterSwitchToWindow method");
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		
		System.out.println("onException method");
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		
		System.out.println("beforeGetScreenshotAs method");
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

		System.out.println("afterGetScreenshotAs method");
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {

		System.out.println("beforeGetText method");
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		
		System.out.println("afterGetText method");
		
	}
	
	
	
	

}
