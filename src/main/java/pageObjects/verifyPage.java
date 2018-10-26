package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class verifyPage extends BasePageObject{
	
public verifyPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public void enterOTP(String optkey) {
		
	sendkeys(By.xpath("//input[@name='token']"), optkey);
}

public boolean userRedirectedToVerifyPage() throws IOException {
	
	return isDisplayed(By.xpath("//*[@id=\"formdiv\"]/h2[contains(text(),'Verify Your')]"));
}


}
