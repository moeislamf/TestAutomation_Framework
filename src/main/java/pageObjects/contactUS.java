package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class contactUS extends BasePageObject {

	public contactUS(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean userIsOnRegistrationPage() throws IOException {
		return isDisplayed(By.xpath("//*[@id=\"fh5co-main\"]//h2[text()='Sign Up']"));
	}
	
	public void fillOutContactForm() throws IOException {

		sendkeys(By.id("name"), "Mohammed Islam");
		sendkeys(By.id("email"), "moeislamf@gmail.com");
		sendkeys(By.id("sub"), "Issue with my account");
		sendkeys(By.id("message"),
				"You are my sunshine my only sunshine. You make me happy when the skys are grey."
				+ " You don't know dear how much I love you. Please don't take my sunshine away.");
		
	}

	public boolean verifyContactUsHeader() throws IOException {
		return isDisplayed(By.xpath("//*[@id=\"contact-form\"]//h3[text()=\"contact us\"]"));
	}
	
	public void sendInquiryButton() throws IOException {
		click(By.xpath("//input[@onclick='sendEnquiry()']"));
	}
	
}
