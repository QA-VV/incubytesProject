package bdd.incubyte;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import bdd.incubyte.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {
	
	public static WebDriver driver;
	public static Logger log;
	public ConfigManager config = new ConfigManager();
	

	

	@Before
	public void beforeScenario() {
		try {

				initiateDriver(config.getProperty("Browser.Name"));
		
				
				
				  
				if (config.getProperty("Environment").equalsIgnoreCase("test")) {
					getDriver().get(config.getProperty("devTestUrl"));
					driver.manage().window().maximize();
					
	
					
				}
				
							

		} catch (Exception e) {
			log.error("Error whlie launching the browser - "+e.getMessage());
			
		}

	}
	
	
	/**
	 * Getter method for WebDriver
	 * 
	 * @return driver
	 */

	public static WebDriver getDriver() {
		return driver;
		
	}

	/**
	 * 
	 * Setter method for WebDriver
	 *
	 * @param driver
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void initiateDriver(String browserType) {

		
		setDriver(browserType);

	}
	private void setDriver(String browserType) {
		switch (browserType) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			System.out.println("browser name: " + browserType + " Launch successfully...:)");
			break;

		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("browser name: " + browserType + " Launch successfully...:)");
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println("browser name: " + browserType + " Launch successfully...:)");
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("browser name: " + browserType + " Launch successfully...:)");
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			System.out.println("browser name: " + browserType + " Launch successfully...:)");			break;

		default:
			log.error("browser : " + browserType + " is invalid, Launching chrome as browser of choice..");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("browser name: " + browserType + " Launch successfully...:)");
		}
	}
	
	/**
	 * 
	 * Method - Explicit Wait
	 * @param element
	 * @param duration
	 */
	public static void waitExplicitly (WebElement element, int duration) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));

		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	/**
	 * 
	 * Method - to scroll the UI
	 * @param element
	 */
	public void scrollIntoViewThroughJavaScriptExecuter(WebElement element) {
		try {
		
	
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
		
		System.out.println("Scroll is done successfully on the element: "+element.toString());
		}
		catch(Exception e) {
		System.out.println("Exception occured while scrolling"+"   "+element.toString());
		}
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		boolean result = false;
		try {
			waitExplicitly(element, 5);
				result = true;
			
		} catch (Exception e) {
			System.out.println("Element not visible : "+element.toString());
		}
		return result;
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		System.out.println("Browser closed successfully....");
	}
	

}
