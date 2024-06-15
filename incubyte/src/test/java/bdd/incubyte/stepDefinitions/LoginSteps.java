package bdd.incubyte.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import bdd.incubyte.BaseSetup;
import bdd.incubyte.ConfigManager;
import bdd.incubyte.Pages.AdidasPage;
import bdd.incubyte.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	public ConfigManager config = new ConfigManager();
	public LoginPage loginpage;
	public AdidasPage ad;
	
	
	WebDriver driver;
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginpage = new LoginPage();
		loginpage.openLoginPage();		
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid(String username, String password) {
	    loginpage.enterUsername(username);
	    loginpage.enterPassword(password);	
	    loginpage.clickSignInBtn();

	}

		

	@Then("Check user is not allowed to login page")
	public void check_user_is_not_allowed_to_login_page() {
		try {
			
			System.out.println("result "+loginpage.welcomeTextVisible());
			Assert.assertFalse(loginpage.welcomeTextVisible(), "Navigation failed");
			
			
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			//Assert.fail();
		}
	}
	
	@Then("Check user is navigated to login page")
	public void check_user_is_navigated_to_login_page() {
	    try {
			
	    	System.out.println("result "+loginpage.welcomeTextVisible());
			Assert.assertTrue(loginpage.welcomeTextVisible(), "Navigation failed");
			
		
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			//Assert.fail();
		}
	}
	
	
	@Given("OPen the WebSite")
	public void o_pen_the_web_site() {
	    ad = new AdidasPage();
	    ad.clickShoes();
	}
	@When("Get the Element")
	public void get_the_element() {
	    ad.clickProducts();
	}
	@Then("CLick the element")
	public void c_lick_the_element() {
	    
	}
	
	


}
