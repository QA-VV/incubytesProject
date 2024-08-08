package bdd.incubyte.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bdd.incubyte.BaseSetup;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;



public class AdidasPage {
	
	WebDriver driver;
	
	public AdidasPage() {
		this.driver = BaseSetup.driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath = "//div[contains(@class,'_product-card')]")
	List <WebElement> dataList;
	
	@FindBy(xpath = "//div[contains(@class,'plp-grid')]/div")
	List <WebElement> productList;
	
	@FindBy(xpath = "(//div[contains(@class,'_product-card')])[1]")
	WebElement shoes;
	
	@FindBy(xpath = "//button[@name='account-portal-close']")
	WebElement closeModalWindow;
	
	@FindBy(xpath = "(//h1[@data-auto-id=\"product-title\"]//span)[2]")
	WebElement productTitle;
	
	
	
	
	
	
	
	//List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'_product-card_')]"));
	
	public void getList () {
		
		List<WebElement> list = dataList;
				
		
		System.out.println("Size of list - " + list.size());
		list.forEach(x -> System.out.println(x));
	}
	
	public void dismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	public void isAlertPresent() 
	{ 
		try 
		{ 
			
			driver.switchTo().alert().dismiss();
			
			System.out.println("Allert visible and Dismissed");
			//return true; 
			
		}  
		catch (NoAlertPresentException Ex) 
		{ 
			System.out.println("Alert not visible.");
			//return false; 
		}   
	}   
	
	public void closeModalWindow() 
	{ 
	    try 
	    {
	    	BaseSetup.waitExplicitly(closeModalWindow, 10);
	    	closeModalWindow.click();
	        
	       
	        //return true; 
	       
	    }  
	    catch (NoAlertPresentException Ex) 
	    { 
	    	System.out.println("Alert not visible.");
	        //return false; 
	    }  
	    catch (NoSuchElementException e) {
			// TODO: handle exception
		}
	}   
	
	
	public void clickShoes() {
		isAlertPresent();
		shoes.click();
		System.out.println("CLiked on Shoes");
	}
	
	public void navigateBack() {
		driver.navigate().back();
		System.out.println("Navigated Back");
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
		System.out.println("Refreshed page");
	}
	
	public String getProductTilte() {
		BaseSetup.waitExplicitly(productTitle, 10);
		return productTitle.getText();
	}
	
	
	public int counter = 0;
	public void clickProducts() {
		
		
		
		System.out.println("Product SIze is - "+productList.size());
		
		
		
		productList.forEach(x -> {
			
			isAlertPresent();
			BaseSetup.waitExplicitly(x, 10);
			x.click();
			closeModalWindow();
			isAlertPresent();
			
			System.out.println("Clicked on Shoe Name - "+ getProductTilte());
			navigateBack();
			refreshPage();
			counter++;
			System.out.println("Counter = "+counter);
			
			});
	}
	
	
	

}
