package register_functionality;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import coreClasses.BaseTestScript;
import pageObjects.registerPage;
import pageObjects.verifyPage;

public class newAccount extends BaseTestScript {

	registerPage register;
	verifyPage verify;

	@Test

	public void registerNewAccount() throws IOException, AWTException {

		register = new registerPage(BaseTestScript.driver);
		register.clickOnRegisterLink();

		register.registration("tex1t1d1ingper6o3@gmail.com", "password", "password");

		verify = new verifyPage(BaseTestScript.driver);
		if (verify.userRedirectedToVerifyPage()) {
			System.out.println("Verify Your Email displayed");

		} else {

			System.out.println("User didn't see Verify Your Email");
			Assert.assertTrue(false);

		}

		//Use robot class to press Ctrl+t keys      
		Robot robot = new Robot();                          
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.keyRelease(KeyEvent.VK_T);

		Set s= BaseTestScript.driver.getWindowHandles();
		BaseTestScript.driver.get("http://www.gmail.com");
		
		System.out.println(s.size());
		
	}
}
