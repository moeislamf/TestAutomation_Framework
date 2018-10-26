package register_functionality;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import coreClasses.BaseTestScript;
import pageObjects.loginPage;
import pageObjects.registerPage;

public class login extends BaseTestScript {
	loginPage login;
	registerPage register;
	
	@Test
	public void login_success() throws IOException, InterruptedException {
	
		login = new loginPage(BaseTestScript.driver);
		login.doLogin("mislam@tcgiit.com", "lookatme");
		if (login.verifyLoginSuccess()) { 
		System.out.println("Login Successful");
		}else {
		System.out.println("Login Failed");
		Assert.assertTrue(false);
			
		}
			
	}
	
	@Test
	public void login_unsuccessful() {
		
				
	}
	
	
}
