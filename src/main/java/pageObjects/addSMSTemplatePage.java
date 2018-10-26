package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class addSMSTemplatePage extends BasePageObject{

	public addSMSTemplatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void createNewTemplate(String templateName, String templateMessage) {
		
		sendkeys(By.id("templateName"), templateName);
		sendkeys(By.id("messageId"), templateMessage);
		
	}
	
	public void clickAddNewTemplate() throws IOException {
		
		click(By.xpath("//button[@type='submit']"));
	}
	
	
}
