package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class registerPage extends BasePageObject {

	public registerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickOnRegisterLink() throws IOException {
		
		click(By.xpath("//div[@id='cssmenu']//a[@href='/account/Register']"));
		
	}
	
	
	public boolean userIsOnRegistrationPage() throws IOException {
		return isDisplayed(By.xpath("//*[@id=\"fh5co-main\"]//h2[text()='Sign Up']"));
	}
	
	public void registration(String email, String password, String confPassword) throws IOException {
		sendkeys(By.id("companyName"), " Test Business");
		sendkeys(By.xpath("//*[@id=\"firstName\"]"), "First Name");
		sendkeys(By.xpath("//*[@id=\"lastName\"]"), "Last Name");
		sendkeys(By.xpath("//*[@id=\"mobile\"]"), "377-533-9121");
		sendkeys(By.xpath("//*[@id=\"EmailAddree\"]"), email);
		sendkeys(By.xpath("//*[@id=\"password\"]"), password);
		sendkeys(By.xpath("//*[@id=\"ConfirmPassword\"]"), confPassword);
		selectOptionFromDropDown(By.name("country"), "Tonga");
		selectOptionFromDropDown(By.name("hearabout"), "Craigs");
		selectOptionFromDropDown(By.name("plan"), "Pay as you go");
		click(By.id("TermsAndConditions"));
		click(By.xpath("//*[@id=\"button\"]"));
	}
	
}
