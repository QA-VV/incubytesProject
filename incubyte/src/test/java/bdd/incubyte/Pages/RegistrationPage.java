package bdd.incubyte.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bdd.incubyte.BaseSetup;

public class RegistrationPage {
	WebDriver driver;
	public RegistrationPage() {
		this.driver = BaseSetup.driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locator of Registration
	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	WebElement logo_homePage;
	
	@FindBy(xpath = "(//a[normalize-space()='Create an Account'])[1]")
	WebElement btn_createAccount;
	
	@FindBy(xpath = "//span[text()='Create New Customer Account']")
	WebElement lbl_registrationForm;
	
	@FindBy(id = "firstname")
	WebElement txt_firstName;
	
	@FindBy(id = "lastname")
	WebElement txt_lastName;
	
	
	@FindBy(id = "email_address")
	WebElement txt_email;
	
	
	@FindBy(id = "password")
	WebElement txt_password;
	
	
	@FindBy(id = "password-confirmation")
	WebElement txt_confirmPassword;
	
	
	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement btn_submitForm;
	
	@FindBy(xpath = "//div[contains(text(),'There is already an account with this email address')]")
	WebElement lbl_userExists;
	
	@FindBy(xpath = "//div[contains(text(),'Thank you for registering with Main Website Store.')]")
	WebElement lbl_userCreated;
	
	
	
	public void openHomepage() {
		logo_homePage.click();
	}
	
	public void createAccountBtnClick() {
		BaseSetup.waitExplicitly(btn_createAccount, 10000);
		btn_createAccount.click();
	}
	
	public boolean registrationForm() {
		BaseSetup.waitExplicitly(lbl_registrationForm, 10000);
		return lbl_registrationForm.isDisplayed();
	}
	
	public void enterFirtName(String firstName) {
		txt_firstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		txt_lastName.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password) {
		txt_confirmPassword.sendKeys(password);
	}
	
	public void clickSubmitBtn() {
		btn_submitForm.click();
	}
	
	public boolean userExistsCheck() {
		
		return BaseSetup.isElementDisplayed(lbl_userExists);
	}
	
	public boolean userCreatedCheck() {
		
		return BaseSetup.isElementDisplayed(lbl_userCreated);
	}
	
	
	
	
	
}
