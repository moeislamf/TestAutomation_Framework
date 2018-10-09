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

	public void doLogin(String email_ID, String password) throws IOException {

		click(By.xpath("//a[@href='/account/login']"));
		// Enter valid email id

		sendkeys(By.id("userName"),email_ID);
		

		// Enter Password
		sendkeys(By.id("password"),email_ID);

		
		// Click on Sign In button

		click(By.xpath("//button[@type='submit']"));

	  // Click on Forgot Password link
	click(By.xpath("//*[@id=\"frmsendsms\"]/div[4]/b/a"));
	  
	}
}
