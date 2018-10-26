package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class loginPage extends BasePageObject {


	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void doLogin(String email_ID, String password) throws IOException, InterruptedException {

		click(By.xpath("//a[@href='/account/login']"));
		// Enter valid email id

		Thread.sleep(5000);
		
		sendkeys(By.id("userName"),email_ID);
		

		// Enter Password
		sendkeys(By.id("password"),password);

		
		// Click on Sign In button

		click(By.xpath("//button[@type='submit']"));

	Thread.sleep(5000);
		
	}
	
	
	public boolean verifyLoginSuccess() throws IOException {
		return isDisplayed(By.xpath("//*[@id=\"container\"]//span[@class='username']"));
		
	}
	
	public boolean verifyErrorMessage4FailedLogin() throws IOException {
		return isDisplayed(By.xpath("//span[@class='red']"));
		
	}
	
	public void clickForgotPassword() throws IOException {
		click(By.xpath("//*[@id=\"frmsendsms\"]/div[4]/b/a"));
	}
}
