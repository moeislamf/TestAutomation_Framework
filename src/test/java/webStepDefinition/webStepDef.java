package webStepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;

import coreClasses.BaseTestScript;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.contactUS;
import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.registerPage;

public class webStepDef {
	homePage homepage;
	registerPage registerpage;
    loginPage loginpage;
    contactUS contactus;
    
	@Given("^user login into application$")
	public void login() throws IOException {
		loginpage = new loginPage(BaseTestScript.driver);
		loginpage.doLogin("mislam@atmsolutionsllc.com", "lookatme");
	}

	@Given("^open browser And navigate to url$")
	public void setup() throws IOException {
		BaseTestScript.beoferTest();
	}

	@When("^user click on \"(.*)\" menu$")
	public void clickMenuItem(String menu) throws IOException {
		homepage = new homePage(BaseTestScript.driver); // Creating an object of page object
		homepage.navigationToMenu(menu); // calling method of the page object
	}

	@SuppressWarnings("deprecation")
	@Then("^user verify navigation to registration page$")
	public void verifyUserOnRegistrationPage() throws IOException {
		registerpage = new registerPage(BaseTestScript.driver);
		Assert.assertEquals(true, registerpage.userIsOnRegistrationPage());
	}
	
	@When("^user enter \"(.*)\" and \"(.*)\" and \"(.*)\" registration details$")
	public void filldRegistrationDetails(String email, String password, String confPassword) throws IOException {
	registerpage.registration(email, password, confPassword);	
	}
	
	@SuppressWarnings("deprecation")
		
	
	@Then("^verify users see Contact US text$")
	public void verifyContactUsHeader() throws IOException {
		contactus = new contactUS(BaseTestScript.driver);
		Assert.assertTrue(contactus.verifyContactUsHeader());
	}
	
	@And("^enter Name and email id and subject and comments$")
	public void fillOutContactForm() throws IOException {
	contactus.fillOutContactForm();
		
	}
	
	@When("^user click on Send button$")
	public void clickSend() throws IOException {
		contactus.sendInquiryButton();
		
	}
	
	
	
}
