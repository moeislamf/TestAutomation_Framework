package adminPageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class AdminLoginPage extends BasePageObject {

	public AdminLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By emailId = By.id("userName");
	By password = By.id("password");
	By Login = By.xpath("//button[@type='submit']");
	
	public void doLogin() throws IOException {
	sendkeys(emailId, "mislam@textingpro.com");	
	sendkeys(password, "lookatme");
	click(Login);
	}
	
}
