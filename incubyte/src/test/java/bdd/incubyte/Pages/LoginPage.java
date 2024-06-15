package bdd.incubyte.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bdd.incubyte.BaseSetup;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage() {
		this.driver = BaseSetup.driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement btn_signIn;
	
	@FindBy(xpath = "//span[contains(text(),'Customer Login')]")
	WebElement header_login;
	
	@FindBy(id = "email" )
	WebElement txt_email;
	
	@FindBy(id = "pass" )
	WebElement txt_password;
	
	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]" )
	WebElement btn_signInSubmit;
	
	@FindBy(xpath = "//div[@class='panel header']//span[contains(text(),'Welcome, Vikas Verma!')]" )
	WebElement lbl_welcometxt;
			
	
	public void openLoginPage() {
		btn_signIn.click();
	}
	
	public void verifyLoginPageHeader() {
		header_login.isDisplayed();
	}
	
	public void enterUsername(String username) {
		txt_email.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickSignInBtn() {
		btn_signInSubmit.click();
	}
	
	public boolean welcomeTextVisible() {
		
		return BaseSetup.isElementDisplayed(lbl_welcometxt);
	}
	
	
}
