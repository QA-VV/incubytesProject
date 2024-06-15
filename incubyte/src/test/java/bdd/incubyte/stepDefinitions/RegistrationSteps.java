package bdd.incubyte.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import bdd.incubyte.ConfigManager;
import bdd.incubyte.Pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
	
	public ConfigManager config = new ConfigManager();
	public RegistrationPage registerpage;
	WebDriver driver;
	
	
	
	@Given("User is on home page")
	public void user_is_on_home_page() {
		registerpage = new RegistrationPage();
		registerpage.openHomepage();
	}

	@When("User cliks on create account button")
	public void user_cliks_on_create_account_button() {
		
		registerpage.createAccountBtnClick();
	    
	}

	@When("User fillup the required registration form.")
	public void user_fillup_the_required_registration_form() {
		registerpage.enterFirtName("Vikas");
		registerpage.enterLastName("Verma");
		registerpage.enterEmail(config.getProperty("username"));
		registerpage.enterPassword(config.getProperty("password"));
		registerpage.enterConfirmPassword(config.getProperty("password"));
	    
	    
	}

	@When("User Click on create Account")
	public void user_click_on_create_account() {
	    registerpage.clickSubmitBtn();
	}

	@Then("Check User is registered successfully.")
	public void check_user_is_registered_successfully() {
		try {
			
			Assert.assertTrue(registerpage.userCreatedCheck(), "Error occured for new registration.");
			
		} catch (Exception e) {
			System.out.println("Error - "+e.getMessage());
		}
		
	}
	@Then("Check User is already registered")
	public void check_user_is_already_registered() {
		try {
			
			Assert.assertTrue(registerpage.userExistsCheck(), "Error occured while checking existing User.");
			
		} catch (Exception e) {
			System.out.println("Error - "+e.getMessage());
		}
	   
	}

	


}
