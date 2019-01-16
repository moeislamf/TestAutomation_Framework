package pageObjects;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class registerPage extends BasePageObject {

	public registerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean userIsOnRegistrationPage() throws IOException {
		return isDisplayed(By.xpath("//*[@id=\"fh5co-main\"]//h2[text()='Sign Up']"));
	}
	
	public void registration() throws IOException {
		sendkeys(By.id("companyName"), " Test Business");
		sendkeys(By.xpath("//*[@id=\"firstName\"]"), "First Name");
		sendkeys(By.xpath("//*[@id=\"lastName\"]"), "Last Name");
		sendkeys(By.xpath("//*[@id=\"mobile\"]"), phoneNumber);
		sendkeys(By.xpath("//*[@id=\"EmailAddree\"]"), random);
		sendkeys(By.xpath("//*[@id=\"password\"]"), "password");
		sendkeys(By.xpath("//*[@id=\"ConfirmPassword\"]"), "password");
		selectOptionFromDropDown(By.name("country"), "Tonga");
		selectOptionFromDropDown(By.name("hearabout"), "Craigs");
		selectOptionFromDropDown(By.name("plan"), "Pay as you go");
		click(By.id("TermsAndConditions"));
		click(By.xpath("//*[@id=\"button\"]"));
	}
	
	
	
}
